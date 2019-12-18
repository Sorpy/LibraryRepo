package application.business.converter.common;

public interface BaseResultConverter <ENT, OUT>{

    OUT convertStandard (ENT entity, OUT result);

    void convertSpecific (ENT entity, OUT result);

    OUT convert(ENT entity);

    OUT getResult();
}
