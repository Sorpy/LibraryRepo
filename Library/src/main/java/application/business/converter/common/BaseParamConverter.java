package application.business.converter.common;

public interface BaseParamConverter <IN, ENT> {
    ENT convertStandard(IN param, ENT entity);

    void convertSpecific (IN param, ENT entity);

    ENT convert (IN param, ENT entity);

    ENT getEntity(IN param);
}
