package br.com.zup.MercadoLivre.Validacoes;

import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class ExistIdValidator implements ConstraintValidator<ExisteId,Object> {

    private String domainAttibute;
    private Class<?> aClass;

    @PersistenceContext
    private EntityManager manager;

    public void initialize(ExisteId constraintAnnotation) {

        this.domainAttibute = constraintAnnotation.fieldName();
        this.aClass = constraintAnnotation.domainClass();
    }


    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        if (o == null){
            return true;
        }
        Query query = manager.createQuery("select 1 from  " + aClass.getName() + " where " + domainAttibute + " =:value");
        query.setParameter("value", o);
        List<?> list  = query.getResultList();
        return  !list.isEmpty();
    }
}
