package com.example.teste;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class TesteMat extends Activity implements OnClickListener {

	Button calcular;
	TextView tvX1;
	TextView tvX2;
	TextView tvX3;
	TextView tvX4;
	TextView tvX5;
	TextView tvX6;
	TextView tvX7;
	TextView tvX8;
	TextView tvX9;
	TextView tvX10;

	TextView tvY1;
	TextView tvY2;
	TextView tvY3;
	TextView tvY4;
	TextView tvY5;
	TextView tvY6;
	TextView tvY7;
	TextView tvY8;
	TextView tvY9;
	TextView tvY10;

	TextView label;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_teste_mat);

		calcular = (Button) findViewById(R.id.button1);
		calcular.setOnClickListener(this);

		tvX1 = (TextView) findViewById(R.id.editText10);
		tvX1.setText("0");
		tvX2 = (TextView) findViewById(R.id.editText11);
		tvX2.setText("0");
		tvX3 = (TextView) findViewById(R.id.editText12);
		tvX3.setText("0");
		tvX4 = (TextView) findViewById(R.id.editText13);
		tvX4.setText("0");
		tvX5 = (TextView) findViewById(R.id.editText14);
		tvX5.setText("0");
		tvX6 = (TextView) findViewById(R.id.editText15);
		tvX6.setText("0");
		tvX7 = (TextView) findViewById(R.id.editText16);
		tvX7.setText("0");
		tvX8 = (TextView) findViewById(R.id.editText17);
		tvX8.setText("0");
		tvX9 = (TextView) findViewById(R.id.editText18);
		tvX9.setText("0");
		tvX10 = (TextView) findViewById(R.id.editText19);
		tvX10.setText("0");

		tvY1 = (TextView) findViewById(R.id.editText20);
		tvY1.setText("0");
		tvY2 = (TextView) findViewById(R.id.editText21);
		tvY2.setText("0");
		tvY3 = (TextView) findViewById(R.id.editText22);
		tvY3.setText("0");
		tvY4 = (TextView) findViewById(R.id.editText23);
		tvY4.setText("0");
		tvY5 = (TextView) findViewById(R.id.editText24);
		tvY5.setText("0");
		tvY6 = (TextView) findViewById(R.id.editText25);
		tvY6.setText("0");
		tvY7 = (TextView) findViewById(R.id.editText26);
		tvY7.setText("0");
		tvY8 = (TextView) findViewById(R.id.editText27);
		tvY8.setText("0");
		tvY9 = (TextView) findViewById(R.id.editText28);
		tvY9.setText("0");
		tvY10 = (TextView) findViewById(R.id.editText29);
		tvY10.setText("0");

		label = (TextView) findViewById(R.id.textView1);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_teste_mat, menu);
		return true;
	}

	public void onClick(View v) {
		boolean erro = false;

		Double somatoriaX = new Double(0);
		Double somatoriaY = new Double(0);
		Double somatoriaX2 = new Double(0);
		Double somatoriaY2 = new Double(0);
		Double somatoriaXY = new Double(0);

		String texto = null;

		List<Double> listaX = new ArrayList<Double>();
		List<Double> listaY = new ArrayList<Double>();

		adicionarListaX(listaX);
		adicionarListaY(listaY);

		int qtdLinhas = listaX.size();

		if (qtdLinhas != listaY.size()) {
			erro = true;
			label.setText("O número de linhas X e Y são diferentes");
		}
		if (qtdLinhas == 0) {
			erro = true;
			label.setText("O número de linhas tem que ser maior que 0");
		}

		if (!erro) {
			for (int i = 0; i < qtdLinhas; i++) {
				double x = listaX.get(i);
				double y = Math.log10(listaY.get(i));
				System.out.println(y);
				somatoriaX += x;
				somatoriaX2 += x * x;
				somatoriaXY += x * y;
				somatoriaY += y;
				somatoriaY2 += y * y;
			}

			texto = "somatoria de X = " + somatoriaX + "\nsomatoria de Y = " + somatoriaY
					+ "\nsomatoria de X2 = " + somatoriaX2 + "\nsomatoria de XY = " + somatoriaXY
					+ "\nsomatoria de Y2 = " + somatoriaY2;

			Double sxx = somatoriaX2 - ((somatoriaX * somatoriaX) / qtdLinhas);
			Double sxy = somatoriaXY - ((somatoriaX * somatoriaY) / qtdLinhas);
			Double syy = somatoriaY2 - ((somatoriaY * somatoriaY) / qtdLinhas);

			texto += "\nSXX = " + sxx + "\nSXY = " + sxy + "\nSYY = " + syy;

			Double bLinha = sxy / sxx;
			Double b = Math.pow(10, bLinha);

			texto += "\nb' = " + bLinha + "\nb = " + b;

			Double aLinha = (somatoriaY / qtdLinhas) /* y_ */
					- (bLinha * (somatoriaX / qtdLinhas) /* x_ */);

			Double a = Math.pow(10, aLinha);

			texto += "\na' = " + aLinha + "\na = " + a + "\nY = " + a + "*" + b + "^x";

			label.setText(texto);
		}
	}

	private void adicionarListaY(List<Double> listaY) {
		double y1 = Double.parseDouble(tvY1.getText().toString());
		double y2 = Double.parseDouble(tvY2.getText().toString());
		double y3 = Double.parseDouble(tvY3.getText().toString());
		double y4 = Double.parseDouble(tvY4.getText().toString());
		double y5 = Double.parseDouble(tvY5.getText().toString());
		double y6 = Double.parseDouble(tvY6.getText().toString());
		double y7 = Double.parseDouble(tvY7.getText().toString());
		double y8 = Double.parseDouble(tvY8.getText().toString());
		double y9 = Double.parseDouble(tvY9.getText().toString());
		double y10 = Double.parseDouble(tvY10.getText().toString());

		if (y1 != 0)
			listaY.add(y1);
		if (y2 != 0)
			listaY.add(y2);
		if (y3 != 0)
			listaY.add(y3);
		if (y4 != 0)
			listaY.add(y4);
		if (y5 != 0)
			listaY.add(y5);
		if (y6 != 0)
			listaY.add(y6);
		if (y7 != 0)
			listaY.add(y7);
		if (y8 != 0)
			listaY.add(y8);
		if (y9 != 0)
			listaY.add(y9);
		if (y10 != 0)
			listaY.add(y10);
	}

	private void adicionarListaX(List<Double> listaX) {
		double x1 = Double.parseDouble(tvX1.getText().toString());
		double x2 = Double.parseDouble(tvX2.getText().toString());
		double x3 = Double.parseDouble(tvX3.getText().toString());
		double x4 = Double.parseDouble(tvX4.getText().toString());
		double x5 = Double.parseDouble(tvX5.getText().toString());
		double x6 = Double.parseDouble(tvX6.getText().toString());
		double x7 = Double.parseDouble(tvX7.getText().toString());
		double x8 = Double.parseDouble(tvX8.getText().toString());
		double x9 = Double.parseDouble(tvX9.getText().toString());
		double x10 = Double.parseDouble(tvX10.getText().toString());

		if (x1 != 0)
			listaX.add(x1);
		if (x2 != 0)
			listaX.add(x2);
		if (x3 != 0)
			listaX.add(x3);
		if (x4 != 0)
			listaX.add(x4);
		if (x5 != 0)
			listaX.add(x5);
		if (x6 != 0)
			listaX.add(x6);
		if (x7 != 0)
			listaX.add(x7);
		if (x8 != 0)
			listaX.add(x8);
		if (x9 != 0)
			listaX.add(x9);
		if (x10 != 0)
			listaX.add(x10);
	}

}
