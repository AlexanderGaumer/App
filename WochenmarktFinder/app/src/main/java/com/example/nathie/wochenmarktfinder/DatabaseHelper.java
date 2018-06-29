package com.example.nathie.wochenmarktfinder;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.LinkedList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {



    public static final String DATABASE_NAME = "Markt.db";
    public static final String TABLE_NAME = "Weekly_Markets";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "Type";
    public static final String COL_3 = "City";
    public static final String COL_4 = "Address";
    public static final String COL_5 = "Business_time";
    public static final String COL_6 = "Contact";
    public static final String COL_7 = "Offer";
    public static final String COL_8 = "Favorite";


    public DatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL("Create Table " + TABLE_NAME + "("+COL_1 +" INTEGER PRIMARY KEY AUTOINCREMENT,"
                +COL_2+" TEXT,"+COL_3+" TEXT," +COL_4+" TEXT,"+COL_5+" TEXT,"+COL_6+" TEXT,"+COL_7+" TEXT,"+COL_8+" INTEGER"+")");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int NewVersion){
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String type, String city, String address,
                              String busines_time, String contact, String offer, int favorite){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, type);
        contentValues.put(COL_3, city);
        contentValues.put(COL_4, address);
        contentValues.put(COL_5, busines_time);
        contentValues.put(COL_6, contact);
        contentValues.put(COL_7, offer);
        contentValues.put(COL_8, favorite);
        long result = db.insert(TABLE_NAME, null, contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }
    public void Set_Favorite_1(int ID){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("Favorite", 1);
        db.update(TABLE_NAME, cv, "id="+ID, null);
        db.close();
    }

    public void Set_Favorite_0(int ID){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("Favorite", 0);
        db.update(TABLE_NAME, cv, "id="+ID, null);
        db.close();
    }


    public List getAllWochenmaerkte() {
        LinkedList WochenmarktListe = new LinkedList();
        String selectQuery = "SELECT * FROM " + DatabaseHelper.TABLE_NAME + " ORDER BY " + DatabaseHelper.COL_1 + " ASC";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Wochenmarkt woma = new Wochenmarkt();
                woma.set_id(cursor.getInt(0));
                woma.setType(cursor.getString(1));
                woma.setCity(cursor.getString(2));
                woma.setAddress(cursor.getString(3));
                woma.setBusiness_time(cursor.getString(4));
                woma.setContact(cursor.getString(5));
                woma.setOffer(cursor.getString(6));
                woma.setFavorite(cursor.getInt(7));
                WochenmarktListe.add(woma);

            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return WochenmarktListe;
    }


    public void AddData(){
        insertData( "Wochen- und Bauernmarkt",
                "Beratzhausen",
                "Am Parkplatz Essenbuegl, Beratzhausen",
                "Samstag 7:00-12:00 Uhr. Falls Samstag ein Feiertag ist, dann finder der Markt am Vortag statt",
                "Herr Braun 09493/940011",
                "Der Markt bietet ein umfassendes Angebot an heimischen Gemuese und Obst, Wurst und Fleischwaren, Kaese und Molkereiprodukten, Honig und Honigprodukten", 0);
        insertData( "Bauernmarkt",
                "Donaustauf",
                "Festplatz, Donaustauf",
                "Freitag 13:30-16:30",
                "Heimat- und Fremdenverkehrsverein Donaustauf e.V. Herr Mihalyi 0171/3735835",
                "Bewusste Ernaehrung mit natuerlich erzeugten Lebensmitteln wie Brot, Kaese, Gemuese, Eier, Wurst, Fleisch, Honig, Gefluegel, Gebaeck, Marmelade, Blumen und Fruechten", 0);
        insertData( "Wochenmarkt",
                "Hemau",
                "Neuer Stadtplatz, Hemau",
                "Mittwoch 8:00-12:30",
                "Stadt Hemau, Herr Andreas Meyer 09491/940018",
                "Obst und Gemuese, Kartoffeln, Kaesespezialitäten,Bio-Obstsäfte, Eier, Frischfleisch, Geraeuchertes, Backwaren aus dem Holzofen, frischer und geraeucherter Fisch sowie Honig und Honigprodukte", 0);
        insertData( "Laaberer Wochenmarkt",
                "Laaber",
                "Marktplatz Laaber",
                "Samstag 7:00-12:00",
                "Herr Schmid, VG Laaber 09498/940115",
                "Umfassendes Angebot an heimischen Obst und Gemuese, Kaese, Brot, Wurstwaren sowie Imkereierzeugnisse",0 );
        insertData( "Wochen- und Bauernmarkt",
                "Neutraubling",
                "Marktplatz vor dem BRK-Altenheim, Neutraubling",
                "Freitag 8:00-12:30",
                "Herr Schwarz, Stadt Neutraubling 09401/80036",
                "Gemuese, Obst, Fleisch, Wurst, Fisch, Kaese, Honig und Honigprodukte, Blumen, Gewuerzkraeuter, Kartoffeln, Wein, Gebaeck, Floristik",0);
        insertData( "Wochenmarkt",
                "Obertraubling",
                "Piesenkofener Strasse",
                "Freitag 14:00-17:00",
                "Gemeinde Obertraubling 09401/96010",
                "Backwaren, Honig, Obst, Gemuese, Kartoffeln, Eier, Kaese, saisonale Produkte",0);
        insertData( "Bauernmarkt",
                "Regenstauf",
                "An der Bruecke, 93128 Regenstauf",
                "Mittwoch 8:00-12:00",
                "Herr Kreisobmann, Johann Mayer 09471/1564",
                "Der Bauernmarkt bietet ein umfassendes Angebot an heimischem Obst und Gemuese, Wurst und Fleischwaren, Biokaese, Eier und Gefluegel sowie Kaffee und Kuchen.",0);
        insertData( "Wochen- und Bauernmarkt",
                "Schierling",
                "Rathausplatz, Schierling",
                "Donnerstag 7:30-12:30",
                "Ernst Roth 09451/3112",
                "Die Marktstaende bieten auf dem Rathausplatz ein breites Warenangebot an Obst, Gemuese, Honig, Fleisch- und Wurstwaren, Bio-Kaese und noch vieles mehr aus der Region an.",0);
        insertData( "Bauernmarkt",
                "Tegernheim",
                "Gewerbegebiet Nord, Tegernheim",
                "Samstag 7:00-13:00",
                "Gemeinde Tegernheim, Frau Luible 09403/952024",
                "Bio-Produkte(Kaese, Eier, Wurst, Brot), frisches Obst und Gemuese, Kartoffeln, Bioaepfel, Eier, Fleisch, Wurst, Backware, Honig und Honigprodukte",0);
        insertData( "Regionalmarkt",
                "Woerth a.d. Donau",
                "Regensburger Strasse, Woerth a.d. Donau",
                "Samstag 8:00-12:00",
                "Frau Hohlschwandner 09482/94030 Herr Richard Schweiger 09404/1414",
                "Grosse Vielfalt an heimischen Lebensmitteln wie Obst, Gemuese, Backwaren, Lammprodukten",0);
        insertData( "Wochenmarkt",
                "Zeitlarn",
                "Hausler Getraenkemarkt, Zeitlarn",
                "Mittwoch 8:00-12:30",
                "Frau Kueffner 09416969323",
                "Saisonales Obst und Gemuese aus regionalem Anbau, saisonale Blumen, Blumenkraenze und Gestecke, Eier, Kartoffeln, Blumenstraeusse, Bio-Frischmilchprodukte wie Joghurt" +
                        "und Kaese, Bio-Fleisch- und Wurstwaren, selbstgemachte Marmelade und Sirup, Backwaren, Holzofenbrot, mediterrane Backspezialitaeten",0);
        insertData( "Bauern- und Wochenmarkt",
                "Regensburg",
                "Bismarckplatz Regensburg",
                "Samstag 9:00-18:00",
                "Stadt Regensburg 0941/5070",
                "Umfangreiches Warenangebot von regionalen und saisonalen Produkten",0);
        insertData( "Bauernmarkt",
                "Regensburg",
                "Altmühlstraße 1, Parkplatz am ehemaligen Autohaus",
                "Donnerstag 13:00-16:30",
                "Herr Kreisobmann 09471/1564, Johann Mayer 09471/1564",
                "Heimisches Obst und Gemüse, Fleisch, Geflügel, Wurst und FLeischwaren, Käse, Brot, Honigprodukte",0);
        insertData( "Bauernmarkt",
                "Regensburg-Burgweinting",
                "BUZ Burgweinting Friedrich-Viehbacher-Allee 3-5 Regensburg",
                "Mittwoch 13:30-17:30",
                "Stadt Regensburg 0941/5070",
                "Obst und Gemuese, Wurst- und Fleischwaren, Kaese und Honig",0);
        insertData( "Bauernmarkt Katharinenmarkt",
                "Regensburg",
                "Stadtamhof Regensburg",
                "Mittwoch 8:00-13:00",
                "Stadt Regensburg 0941/5070",
                "Der Bauernmarkt bietet ein umfassendes Angebot an Backwaren, Nudeln, Gemuese, Honig, Fisch, Biogemuese, Fleisch und Wurstwaren, Kartoffeln, Kaese, Olvenoel, Blumen",0);
        insertData( "Bauernmarkt",
                "Regensburg",
                "Alter Kornmarkt Regensburg",
                "Samstag 5:00-13:00",
                "Stadt Regensburg 0941/5070",
                "Umfassendes Warenangebot an regionalen und saisonalen Produkten",0);
        insertData( "Kartoffelmarkt",
                "Regensburg",
                "Woehrdstrasse 48-54, Regensburg",
                "Mittwoch und Samstag 7:00-12:00",
                "Stadt Regensburg 0941/5070",
                "Kartoffeln aus der Region",0);
        insertData( "Kumpfmuehler Markt",
                "Regensburg",
                "Kumpfmuehler Strasse 48-50 Regensburg",
                "Mittwoch und Samstag 6:00-12:00",
                "Stadt Regensburg 0941/5070",
                "Gemuese, Obst, Eier, Kartoffeln",0);
        insertData( "Viktualienmarkt",
                "Regensburg",
                "Neupfarrplatz Regensburg",
                "Montag bis Samstag 9:00-16:00",
                "Stadt Regensburg 0941/5070",
                "Lebensmittelmarkt mit saisonalem Gemuese und Blumen. Wechselnde Staende mit verschiedenen Angeboten",0);
    }

}