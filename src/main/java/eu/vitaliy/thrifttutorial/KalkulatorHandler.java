package eu.vitaliy.thrifttutorial;

import org.apache.thrift.TException;
import thrifttutorial.KalkulatorService;
import thrifttutorial.Operacja;
import thrifttutorial.Zadanie;

/**
 * User: xaoc
 * Date: 24.07.14
 * Time: 00:35
 */
public class KalkulatorHandler implements KalkulatorService.Iface {
    @Override
    public int wykonajOperacje(Zadanie zadanie) throws TException {
        Operacja operacja = zadanie.getOperacja();
        switch (operacja) {

            case DODAJ:
                return zadanie.getArg1() + zadanie.getArg2();
            case ODEJMIJ:
                return zadanie.getArg1() - zadanie.getArg2();
            case MNOZ:
                return zadanie.getArg1() * zadanie.getArg2();
            case DZIEL:
                return zadanie.getArg1() / zadanie.getArg2();
        }
        return 0;
    }
}
