package com.rev_cws.util.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.rev_cws.utils.EncryptDecrypt;

class EncryptDecryptTest {

	@BeforeAll
	public static void setUpService() {
	}

	@Test
	void testEncrypt() {
		try {
			assertEquals("‚ƒ‰®‰{^P", EncryptDecrypt.encrypt("4"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	void testDecrypt() {
		try {
			assertEquals("4", EncryptDecrypt.decrypt("‚ƒ‰®‰{^P"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
