package business.converter.common;

public interface BaseResultConverter <Tin,Tout>{

    Tout convertStandart (Tin entity, Tout result);

    Tout convertSpecific (Tin entity, Tout result);
}
