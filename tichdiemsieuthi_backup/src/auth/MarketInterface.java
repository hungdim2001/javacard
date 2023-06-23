package auth;

import javacard.security.*;
import javacardx.crypto.Cipher;
import javacard.framework.Shareable;

public interface MarketInterface extends Shareable{
	 public void changeInfoMarketEncode(byte[] keyAESNew );
}
