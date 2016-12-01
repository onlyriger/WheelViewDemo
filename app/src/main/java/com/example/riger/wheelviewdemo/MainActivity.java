package com.example.riger.wheelviewdemo;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;

import com.example.riger.wheelviewdemo.ChangeAddressDialog.OnAddressCListener;
import com.example.riger.wheelviewdemo.ChangeBirthDialog.OnBirthListener;

public class MainActivity extends Activity {

	private TextView mBirth;
	private TextView mAddress;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mBirth = (TextView) findViewById(R.id.tv_birth);
		mAddress = (TextView) findViewById(R.id.tv_address);

		mBirth.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				ChangeBirthDialog mChangeBirthDialog = new ChangeBirthDialog(
						MainActivity.this);
				mChangeBirthDialog.setDate(2016, 12, 01);
				mChangeBirthDialog.show();
				mChangeBirthDialog.setBirthdayListener(new OnBirthListener() {

					@Override
					public void onClick(String year, String month, String day) {
						// TODO Auto-generated method stub
						Toast.makeText(MainActivity.this,
								year + "-" + month + "-" + day,
								Toast.LENGTH_LONG).show();
					}
				});
			}
		});

		mAddress.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				ChangeAddressDialog mChangeAddressDialog = new ChangeAddressDialog(
						MainActivity.this);
				mChangeAddressDialog.setAddress("湖南", "长沙");
				mChangeAddressDialog.show();
				mChangeAddressDialog
						.setAddresskListener(new OnAddressCListener() {

							@Override
							public void onClick(String province, String city) {
								// TODO Auto-generated method stub
								Toast.makeText(MainActivity.this,
										province + "-" + city,
										Toast.LENGTH_LONG).show();
							}
						});
			}
		});
	}
}
