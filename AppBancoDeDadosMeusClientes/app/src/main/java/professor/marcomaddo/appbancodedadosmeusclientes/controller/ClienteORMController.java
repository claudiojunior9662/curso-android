package professor.marcomaddo.appbancodedadosmeusclientes.controller;

import io.realm.Realm;
import professor.marcomaddo.appbancodedadosmeusclientes.model.ClienteORM;

public class ClienteORMController {

    public void insert(ClienteORM value) {
        Realm realm = Realm.getDefaultInstance();
        value.setId(RealmUtil.getNextPrimaryKey(realm, ClienteORM.class, "id"));
        realm.beginTransaction();
        realm.copyToRealm(value);
        realm.commitTransaction();
        realm.close();
    }

}
