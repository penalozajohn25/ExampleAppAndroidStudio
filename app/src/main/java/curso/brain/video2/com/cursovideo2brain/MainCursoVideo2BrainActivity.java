package curso.brain.video2.com.cursovideo2brain;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainCursoVideo2BrainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_curso_video2_brain);
    }

    public void showAlert(View view) {
        Toast toast = Toast.makeText(getApplicationContext(), "Example app by Penalozajohn25", Toast.LENGTH_LONG);
        toast.show();
    }

    public void sortTickets(View view) {
        if(validar()){
            Intent miIntent = new Intent(MainCursoVideo2BrainActivity.this,MainOrderTicketActivity.class);
            EditText email        = (EditText) findViewById(R.id.email);
            EditText tickets      = (EditText) findViewById(R.id.tickets);

            Bundle miBundle = new Bundle();
            miBundle.putString("count", tickets.getText().toString());
            miBundle.putString("email", email.getText().toString());

            miIntent.putExtras(miBundle);
            startActivity(miIntent);
        }
    }

    public boolean validar() {
     boolean retorno = true;
        EditText email        = (EditText) findViewById(R.id.email);
        EditText tickets      = (EditText) findViewById(R.id.tickets);

        String c1 = email.getText().toString();
        String c2 = tickets.getText().toString();

        if(c1.isEmpty()) {
            email.setError("Email Required");
            retorno = false;
        }

        if(c2.isEmpty()) {
            tickets.setError("Count Tickets Required");
            retorno = false;
        }

        if (!validarEmail(c1)){
            email.setError("Email no válido");
            retorno = false;
        }

       return retorno;
    }

    private boolean validarEmail(String email) {
        Pattern pattern = Patterns.EMAIL_ADDRESS;
        return pattern.matcher(email).matches();
    }
}
