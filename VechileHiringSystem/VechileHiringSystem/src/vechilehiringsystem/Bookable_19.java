package vechilehiringsystem;

import java.util.Date;

/**
 *
 * @author Ata
 */
public interface Bookable_19 {
    
    public void bookMe(Date Start, Date End) throws SorryWeDontHaveThatOneExpection_19;
    public void cancelme() throws NoCancellationYouMustPayException_19;
    
}
