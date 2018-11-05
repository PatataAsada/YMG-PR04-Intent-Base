package es.iessaladillo.pedrojoya.pr04.ui.avatar;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import es.iessaladillo.pedrojoya.pr04.R;
import es.iessaladillo.pedrojoya.pr04.data.local.Database;
import es.iessaladillo.pedrojoya.pr04.data.local.model.Avatar;
import es.iessaladillo.pedrojoya.pr04.utils.ResourcesUtils;

public class AvatarActivity extends AppCompatActivity {

    private Intent extra_avatar;
    private Avatar avatar;
    private TextView lblAvatar1;
    private ImageView imgAvatar1;
    private TextView lblAvatar2;
    private ImageView imgAvatar2;
    private TextView lblAvatar3;
    private ImageView imgAvatar3;
    private TextView lblAvatar4;
    private ImageView imgAvatar4;
    private TextView lblAvatar5;
    private ImageView imgAvatar5;
    private TextView lblAvatar6;
    private ImageView imgAvatar6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avatar);
        initViews();
        initListeners();
        initIntent();
    }

    private void initIntent() {
        extra_avatar = getIntent();
        // DEFINE UNA CONSTANTE PARA EXTRA_AVATAR
        avatar = extra_avatar.getParcelableExtra("EXTRA_AVATAR");
        selectedAvatar((int) avatar.getId());
    }

    @SuppressLint("ResourceType")
    private void selectedAvatar(int avatarId) {
        switch (avatarId) {
            case 1:
                selectImageView(imgAvatar1);
                break;
            case 2:
                selectImageView(imgAvatar2);
                break;
            case 3:
                selectImageView(imgAvatar3);
                break;
            case 4:
                selectImageView(imgAvatar4);
                break;
            case 5:
                selectImageView(imgAvatar5);
                break;
            case 6:
                selectImageView(imgAvatar6);
                break;
        }
    }

    private void initListeners() {
        lblAvatar1.setOnClickListener(v -> returnAvatar(1));
        imgAvatar1.setOnClickListener(v -> returnAvatar(1));
        lblAvatar2.setOnClickListener(v -> returnAvatar(2));
        imgAvatar2.setOnClickListener(v -> returnAvatar(2));
        lblAvatar3.setOnClickListener(v -> returnAvatar(3));
        imgAvatar3.setOnClickListener(v -> returnAvatar(3));
        lblAvatar4.setOnClickListener(v -> returnAvatar(4));
        imgAvatar4.setOnClickListener(v -> returnAvatar(4));
        lblAvatar5.setOnClickListener(v -> returnAvatar(5));
        imgAvatar5.setOnClickListener(v -> returnAvatar(5));
        lblAvatar6.setOnClickListener(v -> returnAvatar(6));
        imgAvatar6.setOnClickListener(v -> returnAvatar(6));
    }

    private void returnAvatar(int selected) {
        extra_avatar = new Intent();
        extra_avatar.putExtra("EXTRA_AVATAR", Database.getInstance().queryAvatar(selected));
        setResult(RESULT_OK, extra_avatar);
        finish();
    }

    private void initViews() {
        lblAvatar1 = ActivityCompat.requireViewById(this, R.id.lblAvatar1);
        imgAvatar1 = ActivityCompat.requireViewById(this, R.id.imgAvatar1);
        imgAvatar1.setTag(R.id.imgAvatar1);
        lblAvatar2 = ActivityCompat.requireViewById(this, R.id.lblAvatar2);
        imgAvatar2 = ActivityCompat.requireViewById(this, R.id.imgAvatar2);
        imgAvatar2.setTag(R.id.imgAvatar2);
        lblAvatar3 = ActivityCompat.requireViewById(this, R.id.lblAvatar3);
        imgAvatar3 = ActivityCompat.requireViewById(this, R.id.imgAvatar3);
        imgAvatar3.setTag(R.id.imgAvatar3);
        lblAvatar4 = ActivityCompat.requireViewById(this, R.id.lblAvatar4);
        imgAvatar4 = ActivityCompat.requireViewById(this, R.id.imgAvatar4);
        imgAvatar4.setTag(R.id.imgAvatar4);
        lblAvatar5 = ActivityCompat.requireViewById(this, R.id.lblAvatar5);
        imgAvatar5 = ActivityCompat.requireViewById(this, R.id.imgAvatar5);
        imgAvatar5.setTag(R.id.imgAvatar5);
        lblAvatar6 = ActivityCompat.requireViewById(this, R.id.lblAvatar6);
        imgAvatar6 = ActivityCompat.requireViewById(this, R.id.imgAvatar6);
        imgAvatar6.setTag(R.id.imgAvatar6);
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
