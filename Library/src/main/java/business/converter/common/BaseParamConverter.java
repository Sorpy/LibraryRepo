package business.converter.common;

public interface BaseParamConverter <Tin,Tout> {
    Tout convertStandart (Tin param, Tout entity);

    Tout convertSpecific (Tin param, Tout entity);
}
