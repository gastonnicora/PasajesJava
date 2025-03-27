package com.gastonnicora.pasajes.utils;

import org.mindrot.jbcrypt.BCrypt;

public class HashPassword {
	public static String hashPassword(String password) {
        // Generar un hash con bcrypt
        String salt = BCrypt.gensalt(12); // 12 es el factor de trabajo
        return BCrypt.hashpw(password, salt);
    }

    public static boolean checkPassword(String password, String hashedPassword) {
        // Verificar si la contraseña coincide con el hash
        return BCrypt.checkpw(password, hashedPassword);
    }

}
