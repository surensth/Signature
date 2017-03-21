package surensth.com.signature;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.container)
    FrameLayout container;
//    private static final int REQUEST_EXTERNAL_STORAGE = 1;
//
//    private static String[] PERMISSIONS_STORAGE = {Manifest.permission.WRITE_EXTERNAL_STORAGE};
//    @BindView(R.id.signature_pad)
//    SignaturePad signaturePad;
//    @BindView(R.id.signature_pad_container)
//    RelativeLayout signaturePadContainer;
//    @BindView(R.id.clear_button)
//    Button clearButton;
//    @BindView(R.id.save_button)
//    Button saveButton;
//    @BindView(R.id.buttons_container)
//    LinearLayout buttonsContainer;

    public Bitmap getmBitmap() {
        return mBitmap;
    }

    public void setmBitmap(Bitmap mBitmap) {
        this.mBitmap = mBitmap;
    }

    Bitmap mBitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        openFragmentNoHistory(FormFragment.newInstance());

//        verifyStoragePermissions(this);
//
//        setSignedListener();
    }

    public void openFragmentNoHistory(Fragment fragment) {
        FragmentTransaction ft = getSupportFragmentManager()
                .beginTransaction();
        ft.replace(R.id.container,
                fragment);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        ft.commitAllowingStateLoss();
    }

//    private void setSignedListener() {
//        signaturePad.setOnSignedListener(new SignaturePad.OnSignedListener() {
//            @Override
//            public void onStartSigning() {
//                Toast.makeText(MainActivity.this, "OnStartSigning", Toast.LENGTH_SHORT).show();
//
//            }
//
//            @Override
//            public void onSigned() {
//                saveButton.setEnabled(true);
//                clearButton.setEnabled(true);
//            }
//
//            @Override
//            public void onClear() {
//                saveButton.setEnabled(false);
//                clearButton.setEnabled(false);
//            }
//        });
//    }
//    @Override
//    public void onRequestPermissionsResult(int requestCode,
//                                           @NonNull String permissions[], @NonNull int[] grantResults) {
//        switch (requestCode) {
//            case REQUEST_EXTERNAL_STORAGE: {
//                // If request is cancelled, the result arrays are empty.
//                if (grantResults.length <= 0
//                        || grantResults[0] != PackageManager.PERMISSION_GRANTED) {
//                    Toast.makeText(MainActivity.this, "Cannot write images to external storage", Toast.LENGTH_SHORT).show();
//                }
//            }
//        }
//    }
//    public static void verifyStoragePermissions(Activity activity) {
//        // Check if we have write permission
//        int permission = ActivityCompat.checkSelfPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE);
//
//        if (permission != PackageManager.PERMISSION_GRANTED) {
//            // We don't have permission so prompt the user
//            ActivityCompat.requestPermissions(
//                    activity,
//                    PERMISSIONS_STORAGE,
//                    REQUEST_EXTERNAL_STORAGE
//            );
//        }
//    }
//
//    @OnClick(R.id.clear_button)
//    public void onClickClearButton(){
//        signaturePad.clear();
//    }
//
//    @OnClick(R.id.save_button)
//    public void onClickSaveButton(){
//        Bitmap signatureBitmap = signaturePad.getSignatureBitmap();
//        if (addJpgSignatureToGallery(signatureBitmap)) {
//            Toast.makeText(MainActivity.this, "Signature saved into the Gallery", Toast.LENGTH_SHORT).show();
//        } else {
//            Toast.makeText(MainActivity.this, "Unable to store the signature", Toast.LENGTH_SHORT).show();
//        }
//        if (addSvgSignatureToGallery(signaturePad.getSignatureSvg())) {
//            Toast.makeText(MainActivity.this, "SVG Signature saved into the Gallery", Toast.LENGTH_SHORT).show();
//        } else {
//            Toast.makeText(MainActivity.this, "Unable to store the SVG signature", Toast.LENGTH_SHORT).show();
//
//        }
//    }
//    public boolean addSvgSignatureToGallery(String signatureSvg) {
//        boolean result = false;
//        try {
//            File svgFile = new File(getAlbumStorageDir("SignaturePad"), String.format("Signature_%d.svg", System.currentTimeMillis()));
//            OutputStream stream = new FileOutputStream(svgFile);
//            OutputStreamWriter writer = new OutputStreamWriter(stream);
//            writer.write(signatureSvg);
//            writer.close();
//            stream.flush();
//            stream.close();
//            scanMediaFile(svgFile);
//            result = true;
//        } catch (IOException e) {
//            Log.v("tee","data  avg "+e.getLocalizedMessage());
//            e.printStackTrace();
//        }
//        return result;
//    }
//
//
//    public boolean addJpgSignatureToGallery(Bitmap signature) {
//        boolean result = false;
//        try {
//            File photo = new File(getAlbumStorageDir("SignaturePad"), String.format("Signature_%d.jpg", System.currentTimeMillis()));
//            saveBitmapToJPG(signature, photo);
//            scanMediaFile(photo);
//            result = true;
//        } catch (IOException e) {
//            Log.v("tee","data gallery "+e.getLocalizedMessage());
//
//            e.printStackTrace();
//        }
//        return result;
//    }
//    public File getAlbumStorageDir(String albumName) {
//        // Get the directory for the user's public pictures directory.
//        File path = Environment.getExternalStoragePublicDirectory(
//                Environment.DIRECTORY_PICTURES);
//        path.mkdirs();
//        File file = new File(path, albumName);
//        if (!file.exists()) {
//            file.mkdirs();
//            Log.e("SignaturePad", "Directory not created");
//        }
//        return file;
//    }
//    public void saveBitmapToJPG(Bitmap bitmap, File photo) throws IOException {
//        Bitmap newBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
//        Canvas canvas = new Canvas(newBitmap);
//        canvas.drawColor(Color.WHITE);
//        canvas.drawBitmap(bitmap, 0, 0, null);
//        OutputStream stream = new FileOutputStream(photo);
//        newBitmap.compress(Bitmap.CompressFormat.JPEG, 80, stream);
//        stream.close();
//    }
//    private void scanMediaFile(File photo) {
//        Intent mediaScanIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
//        Uri contentUri = Uri.fromFile(photo);
//        mediaScanIntent.setData(contentUri);
//        MainActivity.this.sendBroadcast(mediaScanIntent);
//    }
}
