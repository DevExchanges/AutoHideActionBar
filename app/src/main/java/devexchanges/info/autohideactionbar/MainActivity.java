package devexchanges.info.autohideactionbar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View textListView = findViewById(R.id.txt_list);
        View textWebView = findViewById(R.id.txt_web);
        View textScrollView = findViewById(R.id.txt_scroll);

        // set event handling for TextViews
        textListView.setOnClickListener(onClickListener(ListViewActivity.class));
        textScrollView.setOnClickListener(onClickListener(ScrollViewActivity.class));
        textWebView.setOnClickListener(onClickListener(WebViewActivity.class));
    }

    private View.OnClickListener onClickListener(final Class<?> c) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToActivity(c);
            }
        };
    }

    private void goToActivity(Class<?> c) {
        Intent intent = new Intent(this, c);
        startActivity(intent);
    }
}
