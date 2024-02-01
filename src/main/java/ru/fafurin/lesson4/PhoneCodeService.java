package ru.fafurin.lesson4;

public class PhoneCodeService {

    public void printCountryByPhoneCode(int phoneCode) {
        System.out.println(getCountryByPhoneCode(phoneCode));
    }

    public void printCountryByPhoneCode(PhoneCode phoneCode) {
        System.out.println(getCountryByPhoneCode(phoneCode.getCode()));
    }

    private String getCountryByPhoneCode(int phoneCode) {
        if (phoneCode == PhoneCode.RUS.getCode()) return PhoneCode.RUS.getName();
        if (phoneCode == PhoneCode.USA.getCode()) return PhoneCode.USA.getName();
        if (phoneCode == PhoneCode.TUR.getCode()) return PhoneCode.TUR.getName();
        if (phoneCode == PhoneCode.FRA.getCode()) return PhoneCode.FRA.getName();
        if (phoneCode == PhoneCode.EGY.getCode()) return PhoneCode.EGY.getName();
        if (phoneCode == PhoneCode.CHN.getCode()) return PhoneCode.CHN.getName();
        if (phoneCode == PhoneCode.MAR.getCode()) return PhoneCode.MAR.getName();
        if (phoneCode == PhoneCode.MEX.getCode()) return PhoneCode.MEX.getName();
        if (phoneCode == PhoneCode.GRC.getCode()) return PhoneCode.GRC.getName();
        if (phoneCode == PhoneCode.SWE.getCode()) return PhoneCode.SWE.getName();
        if (phoneCode == PhoneCode.SGP.getCode()) return PhoneCode.SGP.getName();
        if (phoneCode == PhoneCode.PRK.getCode()) return PhoneCode.PRK.getName();
        else return "There is no country with such a phone code in the database yet";
    }

}
