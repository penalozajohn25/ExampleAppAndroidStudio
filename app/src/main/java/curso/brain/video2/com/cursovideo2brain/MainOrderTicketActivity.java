package curso.brain.video2.com.cursovideo2brain;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainOrderTicketActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_order_ticket);

        Bundle miBundle = this.getIntent().getExtras();
        TextView resultSort = findViewById(R.id.resultSort);
        TextView resultEmail = findViewById(R.id.resultEmail);

        if(miBundle != null) {
            String count = miBundle.getString("count");
            String email = miBundle.getString("email");
            resultSort.setText(count + " Tickets ");
            resultEmail.setText("Tickets sent to " + email);
        }


    }


    public void sortTickets(View view) {
        Intent miIntent = new Intent(MainOrderTicketActivity.this,MainCursoVideo2BrainActivity.class);
        startActivity(miIntent);
    }

}
