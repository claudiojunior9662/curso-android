package professor.marcomaddo.appbancodedadosmeusclientes.controller;

import java.util.Objects;

import io.realm.Realm;

public class RealmUtil {

    public static int getNextPrimaryKey(Realm realm, Class clazz, String primaryKeyFieldName) {
        Number primaryKey = realm.where(clazz).max("id");
        return Objects.isNull(primaryKey) ? 1 : primaryKey.intValue() + 1;
    }
}
