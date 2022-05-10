private static String TAG1 = "APP1";
private Button btnFechar;

@Override
protected void onCreate(Bundle savedInstanceState){
    super.onCreate(savedInstanceState);
    this.btnFechar = (Button) findViewById(R.id.btnClose);

    btnFechar.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View v){
            finish();
        }
    });

    System.out.println("OnCreate");
    Log.d(TAG1, "");
}

@Override
protected void onDestroy(){
    super.onDestroy();
    System.out.println("OnDestroy");
    Log.d(TAG1, "On Destroy");
}

protected void onRestart(){
    super.onRestart();

    System.out.println("OnRestart");
    Log.d(TAG1, "On Restart");
}