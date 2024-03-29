package com.example.sirfscompanion.control;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.BitmapFactory;

import com.example.sirfscompanion.R;
import com.example.sirfscompanion.instanciables.Char;

public class MyDB {

    private MyDatabaseHelper dbHelper;

    private static SQLiteDatabase database;

    public final static String CHAR_TABLE = "characters"; // name of table

    public final static String CHAR_ID = "_id";
    public final static String CHAR_EDITION = "edition";
    public final static String CHAR_NAME = "name";
    public final static String CHAR_IMG = "img";
    public final static String CHAR_CRDATE = "crdate";
    public final static String CHAR_LEVEL = "level";
    public final static String CHAR_RACE = "race";
    public final static String CHAR_CLASS = "class";
    public final static String CHAR_FUE = "fue";
    public final static String CHAR_DES = "des";
    public final static String CHAR_PUN = "pun";
    public final static String CHAR_INT = "int";
    public final static String CHAR_SAB = "sab";
    public final static String CHAR_AGI = "agi";
    public final static String CHAR_VOL = "vol";
    public final static String CHAR_ENC = "enc";
    public final static String CHAR_PV = "pv";
    public final static String CHAR_MAXPV = "maxpv";
    public final static String CHAR_PE = "pe";
    public final static String CHAR_MAXPE = "maxpe";
    public final static String CHAR_ARMOR = "armor";
    public final static String CHAR_MARMOR = "marmor";
    public final static String CHAR_CRITBONUS = "critbonus";
    public final static String CHAR_CRITDMGBONUS = "critdmgbonus";
    public final static String CHAR_SPELLBONUS = "spellbonus";
    public final static String CHAR_SPELLREDBONUS = "spellredbonus";
    public final static String CHAR_WEAPONS = "weapons";
    public final static String CHAR_EQUIP = "equip";
    public final static String CHAR_RELICS = "relics";
    public final static String CHAR_SKILLS = "skills";
    public final static String CHAR_BONUS = "bonus";
    public final static String CHAR_GOLD = "gold";
    public final static String CHAR_INVENTORY = "inventory";

    /**
     * @param context
     */
    public MyDB(Context context) {
        dbHelper = new MyDatabaseHelper(context);
        database = dbHelper.getWritableDatabase();
        dbHelper.onCreate(database);
    }

    public static long createChar(Char c) {
        ContentValues values = new ContentValues();
        values.put(CHAR_ID, nextId());
        values.put(CHAR_EDITION, c.getCharEdition());
        values.put(CHAR_NAME, c.getCharName());
        values.put(CHAR_IMG, c.getCharImg());
        values.put(CHAR_CRDATE, c.getCharDate());
        values.put(CHAR_LEVEL, c.getCharLevel());
        values.put(CHAR_RACE, c.getCharRace());
        values.put(CHAR_CLASS, c.getCharClass());
        values.put(CHAR_FUE, c.getCharFue());
        values.put(CHAR_DES, c.getCharDes());
        values.put(CHAR_PUN, c.getCharPun());
        values.put(CHAR_INT, c.getCharInt());
        values.put(CHAR_SAB, c.getCharSab());
        values.put(CHAR_AGI, c.getCharAgi());
        values.put(CHAR_VOL, c.getCharVol());
        values.put(CHAR_ENC, c.getCharEnc());
        values.put(CHAR_PV, c.getCharPv());
        values.put(CHAR_MAXPV, c.getCharMaxpv());
        values.put(CHAR_PE, c.getCharPe());
        values.put(CHAR_MAXPE, c.getCharMaxpe());
        values.put(CHAR_ARMOR, c.getCharArmor());
        values.put(CHAR_MARMOR, c.getCharMarmor());
        values.put(CHAR_CRITBONUS, c.getCharCritbonus());
        values.put(CHAR_CRITDMGBONUS, c.getCharCritdmgbonus());
        values.put(CHAR_SPELLBONUS, c.getCharSpellbonus());
        values.put(CHAR_SPELLREDBONUS, c.getCharSpellredbonus());
        values.put(CHAR_WEAPONS, c.getCharWeapons());
        values.put(CHAR_EQUIP, c.getCharEquip());
        values.put(CHAR_RELICS, c.getCharRelics());
        values.put(CHAR_SKILLS, c.getCharSkills());
        values.put(CHAR_BONUS, c.getCharBonus());
        values.put(CHAR_GOLD, c.getCharGold());
        values.put(CHAR_INVENTORY, c.getCharInventory());
        return database.insert(CHAR_TABLE, null, values);
    }

    public static long updateChar(Char c) {
        ContentValues values = new ContentValues();
        values.put(CHAR_NAME, c.getCharEdition());
        values.put(CHAR_NAME, c.getCharName());
        values.put(CHAR_IMG, c.getCharImg());
        values.put(CHAR_CRDATE, c.getCharDate());
        values.put(CHAR_LEVEL, c.getCharLevel());
        values.put(CHAR_RACE, c.getCharRace());
        values.put(CHAR_CLASS, c.getCharClass());
        values.put(CHAR_FUE, c.getCharFue());
        values.put(CHAR_DES, c.getCharDes());
        values.put(CHAR_PUN, c.getCharPun());
        values.put(CHAR_INT, c.getCharInt());
        values.put(CHAR_SAB, c.getCharSab());
        values.put(CHAR_AGI, c.getCharAgi());
        values.put(CHAR_VOL, c.getCharVol());
        values.put(CHAR_ENC, c.getCharEnc());
        values.put(CHAR_PV, c.getCharPv());
        values.put(CHAR_MAXPV, c.getCharMaxpv());
        values.put(CHAR_PE, c.getCharPe());
        values.put(CHAR_MAXPE, c.getCharMaxpe());
        values.put(CHAR_ARMOR, c.getCharArmor());
        values.put(CHAR_MARMOR, c.getCharMarmor());
        values.put(CHAR_CRITBONUS, c.getCharCritbonus());
        values.put(CHAR_CRITDMGBONUS, c.getCharCritdmgbonus());
        values.put(CHAR_SPELLBONUS, c.getCharSpellbonus());
        values.put(CHAR_SPELLREDBONUS, c.getCharSpellredbonus());
        values.put(CHAR_WEAPONS, c.getCharWeapons());
        values.put(CHAR_EQUIP, c.getCharEquip());
        values.put(CHAR_RELICS, c.getCharRelics());
        values.put(CHAR_SKILLS, c.getCharSkills());
        values.put(CHAR_BONUS, c.getCharBonus());
        values.put(CHAR_GOLD, c.getCharGold());
        values.put(CHAR_INVENTORY, c.getCharInventory());
        return database.update(CHAR_TABLE, values, "_id = ?", new String[]{String.valueOf(c.getCharId())});
    }

    public static void delete(int id) {
        database.delete(CHAR_TABLE, "_id = ?", new String[]{String.valueOf(id)});
    }

    public static Cursor selectAll() {
        try {
            String[] cols = new String[]{CHAR_ID, CHAR_EDITION, CHAR_NAME, CHAR_IMG, CHAR_CRDATE, CHAR_LEVEL, CHAR_RACE, CHAR_CLASS, CHAR_FUE, CHAR_DES, CHAR_PUN, CHAR_INT, CHAR_SAB, CHAR_AGI, CHAR_VOL, CHAR_ENC, CHAR_PV,
                    CHAR_MAXPV, CHAR_PE, CHAR_MAXPE, CHAR_ARMOR, CHAR_MARMOR, CHAR_CRITBONUS, CHAR_CRITDMGBONUS, CHAR_SPELLBONUS, CHAR_SPELLREDBONUS, CHAR_WEAPONS, CHAR_EQUIP, CHAR_RELICS, CHAR_SKILLS, CHAR_BONUS, CHAR_GOLD, CHAR_INVENTORY};
            Cursor mCursor;
            mCursor = database.query(true, CHAR_TABLE, cols, null
                    , null, null, null, "_id desc", null);
            if (mCursor.getCount() == 0) return null;
            mCursor.moveToFirst();
            return mCursor;
        } catch (Exception e) {
            return null;
        }
    }

    public static int nextId() {
        try {
            String[] cols = new String[]{CHAR_ID};
            Cursor mCursor = database.query(true, CHAR_TABLE, cols, null
                    , null, null, null, "_id desc", null);
            mCursor.moveToFirst();
            int id = mCursor.getInt(0) + 1;
            return id;
        } catch (Exception e) {
            return 0;
        }

    }

    public static void updatePV(int id, int PV) {
        ContentValues cv = new ContentValues();
        cv.put(CHAR_PV, PV);
        database.update(CHAR_TABLE, cv, "_id = ?", new String[]{String.valueOf(id)});
    }

    public static void updatePE(int id, int PE) {
        ContentValues cv = new ContentValues();
        cv.put(CHAR_PE, PE);
        database.update(CHAR_TABLE, cv, "_id = ?", new String[]{String.valueOf(id)});
    }

    public static void updateGold(int id, int gold) {
        ContentValues cv = new ContentValues();
        cv.put(CHAR_GOLD, gold);
        database.update(CHAR_TABLE, cv, "_id = ?", new String[]{String.valueOf(id)});
    }

    public static void updateInv(int id, String inv) {
        ContentValues cv = new ContentValues();
        cv.put(CHAR_INVENTORY, inv);
        database.update(CHAR_TABLE, cv, "_id = ?", new String[]{String.valueOf(id)});
    }

    public static void updateWeapons(int id, String weapons) {
        ContentValues cv = new ContentValues();
        cv.put(CHAR_WEAPONS, weapons);
        database.update(CHAR_TABLE, cv, "_id = ?", new String[]{String.valueOf(id)});
    }

    public static void updateEquipment(int id, String equipment) {
        ContentValues cv = new ContentValues();
        cv.put(CHAR_EQUIP, equipment);
        database.update(CHAR_TABLE, cv, "_id = ?", new String[]{String.valueOf(id)});
    }

    public void insertTest() {
        Char c = new Char("Toni Taronges", "1", BitmapFactory.decodeResource(MainActivity.get_ma().getResources(), R.drawable.alchemist), "2020-03-01", 5, "Humano", "Alquimista", 0, 0, 0, 0, 0, 0, 0, 0, 14, 20, 18, 20, 10, 0, 3, 1, 0, 0, "SableXPARTX1d3+FUEXNEWX-XPARTX-XNEWX-XPARTX-XNEWX-XPARTX-", "", "", "0 1 2 3 8 9 14", "", 300, "PelotaXPARTXPlay with it!XPARTX2");
        createChar(c);
        c = new Char("Tomeu Tomàtiga", "2", BitmapFactory.decodeResource(MainActivity.get_ma().getResources(), R.drawable.assassin), "2020-03-01", 5, "Elfo del Este", "Asesino", -2, -1, 0, +2, +1, 0, 0, 1, 14, 17, 17, 26, 10, 0, 3, 1, 0, 0, "-XPARTX-XNEWX-XPARTX-XNEWX-XPARTX-XNEWX-XPARTX-", "", "", "0 1 2 3 8 11 12", "", 100, "");
        createChar(c);
        c = new Char("Lluc Llimona", "1", BitmapFactory.decodeResource(MainActivity.get_ma().getResources(), R.drawable.barbarian), "2020-03-02", 5, "Elfo del Oeste", "Bárbaro", -2, -1, 0, +2, +1, 0, 0, 0, 14, 17, 17, 26, 10, 0, 3, 1, 0, 0, "-XPARTX-XNEWX-XPARTX-XNEWX-XPARTX-XNEWX-XPARTX-", "", "", "0 1 2 5 7 9 12", "", 100, "");
        createChar(c);
        c = new Char("Simó Sopes", "2", BitmapFactory.decodeResource(MainActivity.get_ma().getResources(), R.drawable.bard), "2020-03-02", 5, "Crunisio", "Bardo", -2, -1, 0, +2, +1, 0, 0, 2, 14, 17, 17, 26, 10, 0, 3, 1, 0, 0, "-XPARTX-XNEWX-XPARTX-XNEWX-XPARTX-XNEWX-XPARTX-", "", "", "0 1 2 5 6 11 14", "", 100, "");
        createChar(c);
        c = new Char("Carles Cirera", "1", BitmapFactory.decodeResource(MainActivity.get_ma().getResources(), R.drawable.hunter), "2020-03-03", 5, "Orco", "Cazador", 3, 0, -2, -2, -1, -1, 1, 0, 14, 26, 17, 20, 10, 0, 3, 1, 0, 0, "-XPARTX-XNEWX-XPARTX-XNEWX-XPARTX-XNEWX-XPARTX-", "", "", "0 1 2 4 8 11 13", "", 100, "");
        createChar(c);
        c = new Char("Xisco Ximbomba", "2", BitmapFactory.decodeResource(MainActivity.get_ma().getResources(), R.drawable.druid), "2020-03-03", 5, "Enano", "Druida", 2, 0, -1, 0, -1, -2, 1, 3, 14, 26, 17, 20, 10, 0, 3, 1, 0, 0, "-XPARTX-XNEWX-XPARTX-XNEWX-XPARTX-XNEWX-XPARTX-", "", "", "0 1 2 4 8 11 13", "", 100, "");
        createChar(c);
        c = new Char("Pep Pilotes", "1", BitmapFactory.decodeResource(MainActivity.get_ma().getResources(), R.drawable.arcane), "2020-03-04", 5, "Dracónido", "Elementarista - Arcano", 2, 0, -1, 0, 0, -2, 1, 0, 14, 26, 17, 20, 10, 0, 3, 1, 0, 0, "-XPARTX-XNEWX-XPARTX-XNEWX-XPARTX-XNEWX-XPARTX-", "", "", "0 1 2 4 6 10 13", "DRAC1 DRAC3", 100, "");
        createChar(c);
        /*c = new Char("Frit de Matançes", "2", BitmapFactory.decodeResource(MainActivity.get_ma().getResources(), R.drawable.fire), "2020-03-04", 5, "Vaark", "Elementarista - Fuego", 2, 0, -1, 0, 0, -2, 1, 4, 14, 26, 17, 20, 10, 0, 3, 1, 0, "-XPARTX-XNEWX-XPARTX-XNEWX-XPARTX-XNEWX-XPARTX-", "", "", "0 1 2 4 8 11 12", "", 100, "");
        createChar(c);
        c = new Char("Tòfol Truita", "1", BitmapFactory.decodeResource(MainActivity.get_ma().getResources(), R.drawable.ice), "2020-03-04", 5, "Félido", "Elementarista - Hielo", 2, 0, -1, 0, 0, -2, 1, 0, 14, 26, 17, 20, 10, 0, 3, 1, 0, "-XPARTX-XNEWX-XPARTX-XNEWX-XPARTX-XNEWX-XPARTX-", "", "", "0 1 2 3 7 11 13", "", 100, "");
        createChar(c);
        c = new Char("Andreu Avellana", "2", BitmapFactory.decodeResource(MainActivity.get_ma().getResources(), R.drawable.earth), "2020-03-04", 5, "Humano", "Elementarista - Tierra", 2, 0, -1, 0, 0, -2, 1, 5, 14, 26, 17, 20, 10, 0, 3, 1, 0, "-XPARTX-XNEWX-XPARTX-XNEWX-XPARTX-XNEWX-XPARTX-", "", "", "0 1 2 5 6 9 12", "", 100, "");
        createChar(c);
        c = new Char("Miquel Mitjançant", "1", BitmapFactory.decodeResource(MainActivity.get_ma().getResources(), R.drawable.warrior), "2020-03-05", 5, "Elfo del Este", "Guerrero", 2, 0, -1, 0, 0, -2, 1, 0, 14, 26, 17, 20, 10, 0, 3, 1, 0, "-XPARTX-XNEWX-XPARTX-XNEWX-XPARTX-XNEWX-XPARTX-", "", "", "0 1 2 5 6 9 12", "", 100, "");
        createChar(c);
        c = new Char("Pere Pera", "2", BitmapFactory.decodeResource(MainActivity.get_ma().getResources(), R.drawable.monk), "2020-03-05", 5, "Elfo del Oeste", "Monje", 2, 0, -1, 0, 0, -2, 1, 6, 14, 26, 17, 20, 10, 0, 3, 1, 0, "-XPARTX-XNEWX-XPARTX-XNEWX-XPARTX-XNEWX-XPARTX-", "", "", "0 1 2 3 8 11 14", "", 100, "");
        createChar(c);
        c = new Char("Queco Quetglas", "1", BitmapFactory.decodeResource(MainActivity.get_ma().getResources(), R.drawable.necromancer), "2020-03-05", 5, "Crunisio", "Nigromante", 2, 0, -1, 0, 0, -2, 1, 0, 14, 26, 17, 20, 10, 0, 3, 1, 0, "-XPARTX-XNEWX-XPARTX-XNEWX-XPARTX-XNEWX-XPARTX-", "", "", "0 1 2 3 7 10 13", "", 100, "");
        createChar(c);
        c = new Char("Biel Bimbolla", "2", BitmapFactory.decodeResource(MainActivity.get_ma().getResources(), R.drawable.paladin), "2020-03-05", 5, "Orco", "Paladín", 2, 0, -1, 0, 0, -2, 1, 7, 14, 26, 17, 20, 10, 0, 3, 1, 0, "-XPARTX-XNEWX-XPARTX-XNEWX-XPARTX-XNEWX-XPARTX-", "", "", "0 1 2 4 7 11 13", "", 100, "");
        createChar(c);*/
    }
}