package com.example.sirfscompanion.firstEdition;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.Html;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.sirfscompanion.R;
import com.example.sirfscompanion.control.MyDB;
import com.example.sirfscompanion.instanciables.Char;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

import de.hdodenhof.circleimageview.CircleImageView;

public class CharacterCreation extends AppCompatActivity {
    private int[] raceStats, classStats;
    private TextView _FUE, _DES, _PUN, _INT, _SAB, _AGI, _VOL;
    private EditText _ccName, _PV, _PE;
    private CircleImageView _civ;
    private Random _r;
    private Spinner _ccRace, _ccClass;
    private Bitmap _myImg;
    private int FUE, DES, PUN, INT, SAB, AGI, VOL, PV, PE;
    private String _raceExtra, _classExtra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_creation);
        setResult(0);
        ActionBar ab = getSupportActionBar();
        assert ab != null;
        ab.setTitle(R.string.creacionPersonaje);
        _r = new Random();
        dracPerks();
        _raceExtra = "";
        _classExtra = "";
        String[] names = getResources().getStringArray(R.array.nombres);
        String[] surname1 = getResources().getStringArray(R.array.apellidos);
        String[] surname2 = getResources().getStringArray(R.array.apellidos2);
        _ccName = findViewById(R.id.ccName);
        _ccName.setHint(names[_r.nextInt(names.length)] + " " + surname1[_r.nextInt(surname1.length)] + surname2[_r.nextInt(surname2.length)]);
        _civ = findViewById(R.id.ccImage);
        _FUE = findViewById(R.id.ccFUEVal);
        _DES = findViewById(R.id.ccDESVal);
        _PUN = findViewById(R.id.ccPUNVal);
        _INT = findViewById(R.id.ccINTVal);
        _SAB = findViewById(R.id.ccSABVal);
        _AGI = findViewById(R.id.ccAGIVal);
        _VOL = findViewById(R.id.ccVOLVal);
        _PV = findViewById(R.id.ccPV);
        _PE = findViewById(R.id.ccPE);
        raceStats = new int[9];
        classStats = new int[9];
        _ccRace = findViewById(R.id.ccRace);
        ArrayAdapter<CharSequence> racesAdapter = ArrayAdapter.createFromResource(this, R.array.races1e, R.layout.spinner);
        racesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        _ccRace.setAdapter(racesAdapter);
        _ccRace.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String[] races = getResources().getStringArray(R.array.races1e);
                String[] aux = getResources().getStringArray(R.array.racesStats1e);
                String aux2 = aux[position];
                aux = aux2.split(" ");
                for (int i = 0; i < aux.length; i++) {
                    raceStats[i] = Integer.parseInt(aux[i]);
                }
                _FUE.setText(String.valueOf(raceStats[0]));
                _DES.setText(String.valueOf(raceStats[1]));
                _PUN.setText(String.valueOf(raceStats[2]));
                _INT.setText(String.valueOf(raceStats[3]));
                _SAB.setText(String.valueOf(raceStats[4]));
                _AGI.setText(String.valueOf(raceStats[5]));
                _VOL.setText(String.valueOf(raceStats[6]));
                _PV.setText(null);
                _PE.setText(null);
                if (parent.getItemAtPosition(position).toString().equals(races[6])) {
                    findViewById(R.id.draclayout).setVisibility(View.VISIBLE);
                } else {
                    findViewById(R.id.draclayout).setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        _ccClass = findViewById(R.id.ccClass);
        ArrayAdapter<CharSequence> classesAdapter = ArrayAdapter.createFromResource(this, R.array.classes1e, R.layout.spinner);
        classesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        _ccClass.setAdapter(classesAdapter);
        _ccClass.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String[] classes = getResources().getStringArray(R.array.classes1e);
                if (parent.getItemAtPosition(position).toString().equals(classes[0]))
                    Glide.with(getApplicationContext()).load(R.drawable.alchemist).asBitmap().into(_civ);
                else if (parent.getItemAtPosition(position).toString().equals(classes[1]))
                    Glide.with(getApplicationContext()).load(R.drawable.assassin).asBitmap().into(_civ);
                else if (parent.getItemAtPosition(position).toString().equals(classes[2]))
                    Glide.with(getApplicationContext()).load(R.drawable.barbarian).asBitmap().into(_civ);
                else if (parent.getItemAtPosition(position).toString().equals(classes[3]))
                    Glide.with(getApplicationContext()).load(R.drawable.bard).asBitmap().into(_civ);
                else if (parent.getItemAtPosition(position).toString().equals(classes[4]))
                    Glide.with(getApplicationContext()).load(R.drawable.hunter).asBitmap().into(_civ);
                else if (parent.getItemAtPosition(position).toString().equals(classes[5]))
                    Glide.with(getApplicationContext()).load(R.drawable.druid).asBitmap().into(_civ);
                else if (parent.getItemAtPosition(position).toString().equals(classes[6]))
                    Glide.with(getApplicationContext()).load(R.drawable.arcane).asBitmap().into(_civ);
                else if (parent.getItemAtPosition(position).toString().equals(classes[7]))
                    Glide.with(getApplicationContext()).load(R.drawable.fire).asBitmap().into(_civ);
                else if (parent.getItemAtPosition(position).toString().equals(classes[8]))
                    Glide.with(getApplicationContext()).load(R.drawable.ice).asBitmap().into(_civ);
                else if (parent.getItemAtPosition(position).toString().equals(classes[9]))
                    Glide.with(getApplicationContext()).load(R.drawable.earth).asBitmap().into(_civ);
                else if (parent.getItemAtPosition(position).toString().equals(classes[10]))
                    Glide.with(getApplicationContext()).load(R.drawable.warrior).asBitmap().into(_civ);
                else if (parent.getItemAtPosition(position).toString().equals(classes[11]))
                    Glide.with(getApplicationContext()).load(R.drawable.monk).asBitmap().into(_civ);
                else if (parent.getItemAtPosition(position).toString().equals(classes[12]))
                    Glide.with(getApplicationContext()).load(R.drawable.necromancer).asBitmap().into(_civ);
                else if (parent.getItemAtPosition(position).toString().equals(classes[13]))
                    Glide.with(getApplicationContext()).load(R.drawable.paladin).asBitmap().into(_civ);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        _ccRace.setSelection(_r.nextInt(_ccRace.getAdapter().getCount()));
        _ccClass.setSelection(_r.nextInt(_ccClass.getAdapter().getCount()));
        _PV.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus && !_PV.getText().equals("")) {
                    if (Integer.parseInt(_PV.getText().toString()) > (20 + raceStats[7] + classStats[7])) {
                        _PV.setText(String.valueOf(20 + raceStats[7] + classStats[7]));
                    } else if (Integer.parseInt(_PV.getText().toString()) < 10) {
                        _PV.setText("10");
                    }
                }
            }
        });
        _PE.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus && !_PE.getText().equals("")) {
                    if (Integer.parseInt(_PE.getText().toString()) > (20 + raceStats[8] + classStats[8])) {
                        _PE.setText(String.valueOf(20 + raceStats[8] + classStats[8]));
                    } else if (Integer.parseInt(_PE.getText().toString()) < 10) {
                        _PE.setText("10");
                    }
                }
            }
        });
    }

    public void dracPerks() {
        String[] titles = getResources().getStringArray(R.array.racesBonus1e)[6].split("XNEWX");
        String[] desc = getResources().getStringArray(R.array.racesBonusDesc1e)[6].split("XNEWX");
        ((TextView) findViewById(R.id.dracbonust1)).setText(Html.fromHtml(titles[0]));
        ((TextView) findViewById(R.id.dracbonusd1)).setText(Html.fromHtml(desc[0]));
        ((TextView) findViewById(R.id.dracbonust2)).setText(Html.fromHtml(titles[1]));
        ((TextView) findViewById(R.id.dracbonusd2)).setText(Html.fromHtml(desc[1]));
        ((TextView) findViewById(R.id.dracpent1)).setText(Html.fromHtml(titles[2]));
        ((TextView) findViewById(R.id.dracpend1)).setText(Html.fromHtml(desc[2]));
        ((TextView) findViewById(R.id.dracpent2)).setText(Html.fromHtml(titles[3]));
        ((TextView) findViewById(R.id.dracpend2)).setText(Html.fromHtml(desc[3]));
        ((RadioButton) findViewById(R.id.drac0)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    ((RadioButton) findViewById(R.id.drac1)).setChecked(false);
                }
            }
        });
        ((RadioButton) findViewById(R.id.drac1)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    ((RadioButton) findViewById(R.id.drac0)).setChecked(false);
                }
            }
        });
        ((RadioButton) findViewById(R.id.drac2)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    ((RadioButton) findViewById(R.id.drac3)).setChecked(false);
                }
            }
        });
        ((RadioButton) findViewById(R.id.drac3)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    ((RadioButton) findViewById(R.id.drac2)).setChecked(false);
                }
            }
        });
    }

    public int roll(View view) {
        _r = new Random();
        int aux;
        if (view.equals(findViewById(R.id.ccPVRoll))) {
            aux = _r.nextInt(20) + raceStats[7] + classStats[7];
            if (aux < 10) aux = 10;
            _PV.setText(String.valueOf(aux));
        } else {
            aux = _r.nextInt(20) + raceStats[8] + classStats[8];
            if (aux < 10) aux = 10;
            _PE.setText(String.valueOf(aux));
        }
        return aux;
    }

    public void max(View view) {
        if (view.equals(findViewById(R.id.ccPVMax))) {
            _PV.setText(String.valueOf(20 + raceStats[7] + classStats[7]));
        } else _PE.setText(String.valueOf(20 + raceStats[8] + classStats[8]));
    }

    public void ccSetImage(View view) {
        Intent i = new Intent(Intent.ACTION_PICK);
        i.setType("image/*");
        String[] mimeTypes = {"image/jpeg", "image/png"};
        i.putExtra(Intent.EXTRA_MIME_TYPES, mimeTypes);
        startActivityForResult(i, 0);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK)
            if (requestCode == 0) {
                try {
                    Uri selectedImage = data.getData();
                    _myImg = MediaStore.Images.Media.getBitmap(this.getContentResolver(), selectedImage);
                    Glide.with(getApplicationContext()).load(selectedImage).asBitmap().into(_civ);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
    }

    public void createCharacter(View view) {
        String name = "";
        if (_ccName.getText().toString().equals("")) {
            name = _ccName.getHint().toString();
            if (_r.nextFloat() <= 0.11) {
                _raceExtra = "FUE";
            } else if (_r.nextFloat() <= 0.22) {
                _raceExtra = "DES";
            } else if (_r.nextFloat() <= 0.33) {
                _raceExtra = "PUN";
            } else if (_r.nextFloat() <= 0.44) {
                _raceExtra = "INT";
            } else if (_r.nextFloat() <= 0.55) {
                _raceExtra = "SAB";
            } else if (_r.nextFloat() <= 0.67) {
                _raceExtra = "AGI";
            } else if (_r.nextFloat() <= 0.78) {
                _raceExtra = "VOL";
            } else if (_r.nextFloat() <= 0.89) {
                _raceExtra = "PV";
            } else if (_r.nextFloat() <= 1) {
                _raceExtra = "PE";
            }
            if (_r.nextBoolean()) _classExtra = "FUE";
            else _classExtra = "DES";
        } else name = _ccName.getText().toString();
        String date = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
        if (_myImg == null) {
            _myImg = ((BitmapDrawable) _civ.getDrawable()).getBitmap();
        }
        String race = _ccRace.getSelectedItem().toString();
        String myClass = _ccClass.getSelectedItem().toString();
        FUE = Integer.parseInt(_FUE.getText().toString());
        if (_raceExtra.equals("FUE")) FUE++;
        if (_classExtra.equals("FUE")) FUE++;
        DES = Integer.parseInt(_DES.getText().toString());
        if (_raceExtra.equals("DES")) DES++;
        if (_classExtra.equals("DES")) DES++;
        PUN = Integer.parseInt(_PUN.getText().toString());
        if (_raceExtra.equals("PUN")) PUN++;
        INT = Integer.parseInt(_INT.getText().toString());
        if (_raceExtra.equals("INT")) INT++;
        SAB = Integer.parseInt(_SAB.getText().toString());
        if (_raceExtra.equals("SAB")) SAB++;
        AGI = Integer.parseInt(_AGI.getText().toString());
        if (_raceExtra.equals("AGI")) AGI++;
        VOL = Integer.parseInt(_VOL.getText().toString());
        if (_raceExtra.equals("VOL")) VOL++;
        if (!_PV.getText().toString().equals("")) PV = Integer.parseInt(_PV.getText().toString());
        else PV = roll(findViewById(R.id.ccPVRoll));
        if (_raceExtra.equals("PV")) PV += 5;
        if (!_PE.getText().toString().equals("")) PE = Integer.parseInt(_PE.getText().toString());
        else PE = roll(findViewById(R.id.ccPERoll));
        if (_raceExtra.equals("PE")) PE += 5;
        int armor = 0;
        int marmor = 0;
        int critbonus = 0;
        int critdmgbonus = 0;
        int spellbonus = 0;
        String bonus = "";
        if (race.equals(getResources().getStringArray(R.array.races1e)[6])) {
            if (((RadioButton) findViewById(R.id.drac0)).isChecked()) {
                bonus += " DRAC0";
            } else if (((RadioButton) findViewById(R.id.drac1)).isChecked()) {
                bonus += " DRAC1";
            } else {
                if (_r.nextBoolean()) bonus += " DRAC0";
                else bonus += " DRAC1";
            }
            if (((RadioButton) findViewById(R.id.drac2)).isChecked()) {
                bonus += " DRAC2";
            } else if (((RadioButton) findViewById(R.id.drac3)).isChecked()) {
                bonus += " DRAC3";
            } else {
                if (_r.nextBoolean()) bonus += " DRAC2";
                else bonus += " DRAC3";
            }
        }
        int gold = 50;

        if (race.equals(getResources().getStringArray(R.array.races1e)[0])) {
            if (_raceExtra.equals("")) humanExtra();
            gold *= 3;
        } else if (race.equals(getResources().getStringArray(R.array.races1e)[1])) {
            marmor += 10;
        } else if (race.equals(getResources().getStringArray(R.array.races1e)[2])) {
            if (FUE >= 3 || DES >= 3 || PUN >= 3 || INT >= 3 || SAB >= 3 || AGI >= 3 || VOL >= 3) {
                critbonus += 1;
                bonus += " WECRIT";
            }
        } else if (race.equals(getResources().getStringArray(R.array.races1e)[6])) {
            if (bonus.contains("DRAC0")) armor += 7;
        }

        if (myClass.equals(getResources().getStringArray(R.array.classes1e)[2])) {
            PV += 5;
        } else if (myClass.equals(getResources().getStringArray(R.array.classes1e)[10])) {
            if (_classExtra.equals("")) warriorExtra();
            PV += 5;
        }
        if (!((race.equals(getResources().getStringArray(R.array.races1e)[0])) && _raceExtra.equals("")) && !((myClass.equals(getResources().getStringArray(R.array.classes1e)[10])) && _classExtra.equals(""))) {
            Char c = new Char(name, _myImg, date, 1, race, myClass, FUE, DES, PUN, INT, SAB, AGI, VOL, PV, PV, PE, PE, armor, marmor, critbonus, critdmgbonus,
                    spellbonus, "", "", "", "0 1 2", bonus, gold, "");
            MyDB.createChar(c);
            Intent i = new Intent();
            i.putExtra("CHAR", c);
            setResult(1, i);
            finish();
        }

    }

    public void warriorExtra() {
        final Dialog d = new Dialog(this);
        d.setContentView(R.layout.levelupstats);
        ((TextView) d.findViewById(R.id.luLevel)).setText("¡Bienvenido, bravo Guerrero!");
        (d.findViewById(R.id.luFUE)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _classExtra = "FUE";
                d.cancel();
            }
        });
        (d.findViewById(R.id.luDES)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _classExtra = "DES";
                d.cancel();
            }
        });
        (d.findViewById(R.id.luPUN)).setVisibility(View.GONE);
        (d.findViewById(R.id.luINT)).setVisibility(View.GONE);
        (d.findViewById(R.id.luSAB)).setVisibility(View.GONE);
        (d.findViewById(R.id.luAGI)).setVisibility(View.GONE);
        (d.findViewById(R.id.luVOL)).setVisibility(View.GONE);
        (d.findViewById(R.id.luPV)).setVisibility(View.GONE);
        (d.findViewById(R.id.luPE)).setVisibility(View.GONE);
        d.show();
    }

    public void humanExtra() {
        final Dialog d = new Dialog(this);
        d.setContentView(R.layout.levelupstats);
        ((TextView) d.findViewById(R.id.luLevel)).setText("¡Bienvenido, noble Humano!");
        (d.findViewById(R.id.luFUE)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _raceExtra = "FUE";
                d.cancel();
            }
        });
        (d.findViewById(R.id.luDES)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _raceExtra = "DES";
                d.cancel();
            }
        });
        (d.findViewById(R.id.luPUN)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _raceExtra = "PUN";
                d.cancel();
            }
        });
        (d.findViewById(R.id.luINT)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _raceExtra = "INT";
                d.cancel();
            }
        });
        (d.findViewById(R.id.luSAB)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _raceExtra = "SAB";
                d.cancel();
            }
        });
        (d.findViewById(R.id.luAGI)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _raceExtra = "AGI";
                d.cancel();
            }
        });
        (d.findViewById(R.id.luVOL)).setVisibility(View.VISIBLE);
        (d.findViewById(R.id.luVOL)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _raceExtra = "VOL";
                d.cancel();
            }
        });
        (d.findViewById(R.id.luPV)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _raceExtra = "PV";
                d.cancel();
            }
        });
        (d.findViewById(R.id.luPE)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _raceExtra = "PE";
                d.cancel();
            }
        });
        d.show();
    }
}

