package gestion_pret_boutiquier.Data.enums;

public enum Role {
    BOUTIQUIER, CLIENT, ADMIN;
public static Role getValue(String roleName) {
for (Role role : Role.values()) { 
    if (role.name() .compareTo(roleName)==0) {
        return role;

    }
}
return null;
}
}


