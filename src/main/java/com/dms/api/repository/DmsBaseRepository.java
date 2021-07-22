package com.dms.api.repository;

import com.querydsl.core.types.EntityPath;
import com.querydsl.core.types.Expression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.JpaEntityInformationSupport;
import org.springframework.data.util.ProxyUtils;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public abstract class DmsBaseRepository<E, ID> {

  @PersistenceContext
  private EntityManager em;

  @Autowired
  private JPAQueryFactory queryFactory;
  private JpaEntityInformation<E, ID> entityInformation;

  protected <DTO> JPAQuery<DTO> select(Expression<DTO> expr) {
    return queryFactory.select(expr);
  }

  protected JPAQuery<E> selectFrom(EntityPath<E> from) {
    return queryFactory.selectFrom(from);
  }

  @Transactional
  public E save(E entity) {
    if (isNewEntity(entity)) {
      em.persist(entity);
      return entity;
    }

    return em.merge(entity);
  }

  @Transactional
  @SuppressWarnings("unchecked")
  public void delete(E entity) {
    JpaEntityInformation<E, ID> entityInformation = this.getJpaEntityInformation(entity.getClass());
    if (isNewEntity(entity)) {
      return;
    }

    E existing = (E) em.find(ProxyUtils.getUserClass(entity), entityInformation.getId(entity));
    if (existing == null) {
      return;
    }

    em.remove(em.contains(entity) ? entity : em.merge(entity));
  }

  @SuppressWarnings("unchecked")
  private JpaEntityInformation<E, ID> getJpaEntityInformation(Class<?> clazz) {
    if (this.entityInformation == null) {
      this.entityInformation =
          (JpaEntityInformation<E, ID>) JpaEntityInformationSupport.getEntityInformation(clazz, em);
    }

    return this.entityInformation;
  }

  private Boolean isNewEntity(E entity) {
    return this.getJpaEntityInformation(entity.getClass()).isNew(entity);
  }
}
