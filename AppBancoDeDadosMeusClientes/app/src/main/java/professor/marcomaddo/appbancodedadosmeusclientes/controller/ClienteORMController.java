package professor.marcomaddo.appbancodedadosmeusclientes.controller;

import android.icu.text.DateFormat;
import android.util.Log;

import java.util.List;
import java.util.Objects;

import io.realm.Realm;
import io.realm.RealmResults;
import io.realm.exceptions.RealmException;
import professor.marcomaddo.appbancodedadosmeusclientes.model.Cliente;
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

    public void update(ClienteORM value) {
        Realm realm = Realm.getDefaultInstance();
        ClienteORM clienteORM = realm.where(ClienteORM.class).equalTo("id", value.getId()).findFirst();
        if(Objects.nonNull(clienteORM)) {
            realm.beginTransaction();
            clienteORM.updateEntity(value);
            realm.commitTransaction();
        }
        realm.close();
    }

    public void deleteById(List<Integer> ids) {
        Realm realm = Realm.getDefaultInstance();
        RealmResults<ClienteORM> result = realm.where(ClienteORM.class).in("id", ids.toArray(new Integer[ids.size()])).findAll();
        realm.beginTransaction();
        result.deleteAllFromRealm();
        realm.commitTransaction();
        realm.close();
    }

    public List<ClienteORM> listar() {
        Realm realm = null;
        try {
            realm = Realm.getDefaultInstance();
            RealmResults<ClienteORM> founded = realm.where(ClienteORM.class).findAll();
            List<ClienteORM> result = realm.copyFromRealm(founded);
            return result;
        } catch (RealmException ex) {
            Log.e("db_error", "erro db ao listar: ", ex);
        } finally {
            realm.close();
        }
        return null;
    }

    public ClienteORM getById(Integer id) {
        Realm realm = Realm.getDefaultInstance();
        ClienteORM result = null;

        try {
            result = realm.copyFromRealm(Objects.requireNonNull(realm.where(ClienteORM.class)).equalTo("id", id).findFirst());
        } catch (Exception e) {
            Log.e("db_error", "getById: " + e.getMessage());
        }

        return result;
    }
}
