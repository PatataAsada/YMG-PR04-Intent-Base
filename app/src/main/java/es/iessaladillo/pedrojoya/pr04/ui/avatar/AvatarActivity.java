package es.iessaladillo.pedrojoya.pr04.ui.avatar;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import es.iessaladillo.pedrojoya.pr04.R;
import es.iessaladillo.pedrojoya.pr04.utils.ResourcesUtils;

public class AvatarActivity extends AppCompatActivity {

    TextView lblAvatar1;
    ImageView imgAvatar1;
    TextView lblAvatar2;
    ImageView imgAvatar2;
    TextView lblAvatar3;
    ImageView imgAvatar3;
    TextView lblAvatar4;
    ImageView imgAvatar4;
    TextView lblAvatar5;
    ImageView imgAvatar5;
    TextView lblAvatar6;
    ImageView imgAvatar6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avatar);
        initViews();
        initListeners();
    }

    private void initListeners() {

    }

    private void initViews() {
        lblAvatar1 = ActivityCompat.requireViewById(this, R.id.lblAvatar1);
        imgAvatar1 = ActivityCompat.requireViewById(this, R.id.imgAvatar1);
        lblAvatar2 = ActivityCompat.requireViewById(this, R.id.lblAvatar2);
        imgAvatar2 = ActivityCompat.requireViewById(this, R.id.imgAvatar2);
        lblAvatar3 = ActivityCompat.requireViewById(this, R.id.lblAvatar3);
        imgAvatar3 = ActivityCompat.requireViewById(this, R.id.imgAvatar3);
        lblAvatar4 = ActivityCompat.requireViewById(this, R.id.lblAvatar4);
        imgAvatar4 = ActivityCompat.requireViewById(this, R.id.imgAvatar4);
        lblAvatar5 = ActivityCompat.requireViewById(this, R.id.lblAvatar5);
        imgAvatar5 = ActivityCompat.requireViewById(this, R.id.imgAvatar5);
        lblAvatar6 = ActivityCompat.requireViewById(this, R.id.lblAvatar6);
        imgAvatar6 = ActivityCompat.requireViewById(this, R.id.imgAvatar6);
    }

    // DO NO TOUCH
    private void selectImageView(ImageView imageView) {
        imageView.setAlpha(ResourcesUtils.getFloat(this, R.dimen.selected_image_alpha));
    }

    // DO NOT TOUCH
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

}
