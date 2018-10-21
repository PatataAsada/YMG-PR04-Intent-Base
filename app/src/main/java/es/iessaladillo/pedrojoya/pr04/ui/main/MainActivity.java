package es.iessaladillo.pedrojoya.pr04.ui.main;

import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

import java.util.Objects;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import es.iessaladillo.pedrojoya.pr04.R;
import es.iessaladillo.pedrojoya.pr04.data.local.Database;
import es.iessaladillo.pedrojoya.pr04.data.local.model.Avatar;
import es.iessaladillo.pedrojoya.pr04.utils.ValidationUtils;

@SuppressWarnings("WeakerAccess")
public class MainActivity extends AppCompatActivity {

    private TextView lblAvatar;
    private ImageView imgAvatar;
    private TextView lblName;
    private EditText txtName;
    private TextView lblEmail;
    private EditText txtEmail;
    private ImageView imgEmail;
    private TextView lblPhonenumber;
    private EditText txtPhonenumber;
    private ImageView imgPhonenumber;
    private TextView lblAddress;
    private EditText txtAddress;
    private ImageView imgAddress;
    private TextView lblWeb;
    private EditText txtWeb;
    private ImageView imgWeb;
    private Intent intention;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initListeners();
    }

    private void initListeners() {
        //Focus Listeners
        focusListeners();

        //Text change Listeners
        textChangedListeners();

        //Icon press listeners.
        iconListeners();

        //When pressing avatar image or name.
        imgAvatar.setOnClickListener(v -> {

        });
        lblAvatar.setOnClickListener(v -> {

        });
    }

    private void iconListeners() {
        imgEmail.setOnClickListener(v -> {
            intention = new Intent();
            intention.setAction(Intent.ACTION_SEND);
            intention.putExtra(Intent.EXTRA_EMAIL, txtEmail.getText());
            startActivity(intention);
        });
        imgPhonenumber.setOnClickListener(v -> {
            intention = new Intent(Intent.ACTION_DIAL);
            intention.setData(Uri.parse("tel:"+txtPhonenumber.getText()));
            startActivity(intention);
        });
    }

    private void textChangedListeners() {
        txtName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (count == 0) {
                    txtName.setError(getString(R.string.main_invalid_data));
                    lblName.setEnabled(false);
                } else lblName.setEnabled(true);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        txtEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!ValidationUtils.isValidEmail(txtEmail.getText().toString())) {
                    txtEmail.setError(getString(R.string.main_invalid_data));
                    lblEmail.setEnabled(false);
                    imgEmail.setEnabled(false);
                } else {
                    lblEmail.setEnabled(true);
                    imgEmail.setEnabled(true);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        txtPhonenumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!ValidationUtils.isValidPhone(txtPhonenumber.getText().toString())) {
                    txtPhonenumber.setError(getString(R.string.main_invalid_data));
                    lblPhonenumber.setEnabled(false);
                    imgPhonenumber.setEnabled(false);
                } else {
                    lblPhonenumber.setEnabled(true);
                    imgPhonenumber.setEnabled(true);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        txtAddress.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (count == 0) {
                    txtAddress.setError(getString(R.string.main_invalid_data));
                    lblAddress.setEnabled(false);
                    imgAddress.setEnabled(false);
                } else {
                    lblAddress.setEnabled(true);
                    imgAddress.setEnabled(true);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        txtWeb.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!ValidationUtils.isValidUrl(txtWeb.getText().toString())) {
                    txtWeb.setError(getString(R.string.main_invalid_data));
                    lblWeb.setEnabled(false);
                    imgWeb.setEnabled(false);
                } else {
                    lblWeb.setEnabled(true);
                    imgWeb.setEnabled(true);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        //When pressing IME done button.
        txtWeb.setOnEditorActionListener((v, actionId, event) -> {
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                save();
                InputMethodManager imm =
                        (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                Objects.requireNonNull(imm).hideSoftInputFromWindow(v.getWindowToken(), 0);
                return true;
            }
            return false;
        });
    }

    private void focusListeners() {
        txtName.setOnFocusChangeListener((v, hasFocus) -> {
            if (hasFocus) lblName.setTypeface(Typeface.DEFAULT_BOLD);
            else lblName.setTypeface(Typeface.DEFAULT);
        });
        txtEmail.setOnFocusChangeListener((v, hasFocus) -> {
            if (hasFocus) {
                lblEmail.setTypeface(Typeface.DEFAULT_BOLD);
            } else lblEmail.setTypeface(Typeface.DEFAULT);
        });
        txtPhonenumber.setOnFocusChangeListener((v, hasFocus) -> {
            if (hasFocus) {
                lblPhonenumber.setTypeface(Typeface.DEFAULT_BOLD);
            } else lblPhonenumber.setTypeface(Typeface.DEFAULT);
        });
        txtAddress.setOnFocusChangeListener((v, hasFocus) -> {
            if (hasFocus) {
                lblAddress.setTypeface(Typeface.DEFAULT_BOLD);
            } else lblAddress.setTypeface(Typeface.DEFAULT);
        });
        txtWeb.setOnFocusChangeListener((v, hasFocus) -> {
            if (hasFocus) {
                lblWeb.setTypeface(Typeface.DEFAULT_BOLD);
            } else lblWeb.setTypeface(Typeface.DEFAULT);
        });
    }

    private void initViews() {
        //AVATAR
        imgAvatar = ActivityCompat.requireViewById(this, R.id.imgAvatar);
        lblAvatar = ActivityCompat.requireViewById(this, R.id.lblAvatar);
        setDefault(imgAvatar, lblAvatar);
        //NAME
        lblName = ActivityCompat.requireViewById(this, R.id.lblName);
        lblName.setTypeface(Typeface.DEFAULT_BOLD);
        txtName = ActivityCompat.requireViewById(this, R.id.txtName);
        //EMAIL
        lblEmail = ActivityCompat.requireViewById(this, R.id.lblEmail);
        txtEmail = ActivityCompat.requireViewById(this, R.id.txtEmail);
        imgEmail = ActivityCompat.requireViewById(this, R.id.imgEmail);
        imgEmail.setTag(R.drawable.ic_email_24dp);
        //PHONENUMBER
        lblPhonenumber = ActivityCompat.requireViewById(this, R.id.lblPhonenumber);
        txtPhonenumber = ActivityCompat.requireViewById(this, R.id.txtPhonenumber);
        imgPhonenumber = ActivityCompat.requireViewById(this, R.id.imgPhonenumber);
        imgPhonenumber.setTag(R.drawable.ic_call_24dp);
        //ADDRESS
        lblAddress = ActivityCompat.requireViewById(this, R.id.lblAddress);
        txtAddress = ActivityCompat.requireViewById(this, R.id.txtAddress);
        imgAddress = ActivityCompat.requireViewById(this, R.id.imgAddress);
        imgAddress.setTag(R.drawable.ic_map_24dp);
        //WEB
        lblWeb = ActivityCompat.requireViewById(this, R.id.lblWeb);
        txtWeb = ActivityCompat.requireViewById(this, R.id.txtWeb);
        imgWeb = ActivityCompat.requireViewById(this, R.id.imgWeb);
        imgWeb.setTag(R.drawable.ic_web_24dp);
    }

    private void setDefault(ImageView imgAvatar, TextView nameAvatar) {
        Avatar defAvatar = Database.getInstance().getDefaultAvatar();
        imgAvatar.setImageResource(defAvatar.getImageResId());
        imgAvatar.setTag(defAvatar.getImageResId());
        nameAvatar.setText(defAvatar.getName());
    }

    // DO NOT TOUCH
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    // DO NOT TOUCH
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.mnuSave) {
            save();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void save() {
        boolean validation = true;
        if (txtName.getText().toString().equals("")) {
            validation = false;
            txtName.setText("");
        }
        if (txtEmail.getText().toString().equals("")) {
            validation = false;
            txtEmail.setText("");
        } else if (!ValidationUtils.isValidEmail(txtEmail.getText().toString())) {
            validation = false;
        }
        if (txtPhonenumber.getText().toString().equals("")) {
            validation = false;
            txtPhonenumber.setText("");
        } else if (!ValidationUtils.isValidPhone(txtPhonenumber.getText().toString()))
            validation = false;

        if (txtAddress.getText().toString().equals("")) {
            validation = false;
            txtAddress.setText("");
        }
        if (txtWeb.getText().toString().equals("")) {
            validation = false;
            txtWeb.setText("");
        } else if (!ValidationUtils.isValidUrl(txtWeb.getText().toString())) validation = false;


        if (validation) {
            Snackbar.make(txtWeb, getText(R.string.main_saved_succesfully).toString(), Snackbar.LENGTH_SHORT).show();
        } else
            Snackbar.make(txtWeb, getText(R.string.main_error_saving).toString(), Snackbar.LENGTH_SHORT).show();
    }

}
