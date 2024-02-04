package latihan.membuat.latihanmembuatkomponen;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private EditText editNama;
    private RadioGroup radioGroup;
    private CheckBox cbCoding, cbReading, cbTraveling;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize your views
        editNama = findViewById(R.id.editNama);
        radioGroup = findViewById(R.id.radioGroup);
        cbCoding = findViewById(R.id.cbCoding);
        cbReading = findViewById(R.id.cbReading);
        cbTraveling = findViewById(R.id.cbTraveling);

        // Initialize ImageButtons
        ImageButton imgButtonAdd = findViewById(R.id.imgButtonAdd);
        ImageButton imgButtonCancel = findViewById(R.id.imgButtonCancel);

        // Set click listeners for ImageButtons
        imgButtonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Show Snackbar with the input values
                showSnackbar();
                // Clear input fields
                clearInputs();
            }
        });

        imgButtonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Clear input fields
                clearInputs();
            }
        });
    }

    private void showSnackbar() {
        // Get input values
        String nama = editNama.getText().toString();
        String gender = getSelectedRadioButtonText();
        String hobbies = getSelectedCheckBoxesText();

        // Create a message for the Snackbar
        String message = "Nama: " + nama + "\nGender: " + gender + "\nHobbies: " + hobbies;

        // Show the Snackbar
        Snackbar.make(findViewById(android.R.id.content), message, Snackbar.LENGTH_LONG).show();
    }

    private String getSelectedRadioButtonText() {
        int selectedId = radioGroup.getCheckedRadioButtonId();
        RadioButton selectedRadioButton = findViewById(selectedId);
        return selectedRadioButton != null ? selectedRadioButton.getText().toString() : "";
    }

    private String getSelectedCheckBoxesText() {
        StringBuilder selectedHobbies = new StringBuilder();

        if (cbCoding.isChecked()) {
            selectedHobbies.append("Coding, ");
        }

        if (cbReading.isChecked()) {
            selectedHobbies.append("Reading, ");
        }

        if (cbTraveling.isChecked()) {
            selectedHobbies.append("Traveling");
        }

        return selectedHobbies.toString();
    }

    private void clearInputs() {
        editNama.getText().clear();
        radioGroup.clearCheck();
        cbCoding.setChecked(false);
        cbReading.setChecked(false);
        cbTraveling.setChecked(false);
    }
}
