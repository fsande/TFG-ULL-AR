    DrawerLayout drawerLayout; //Atributo del Navigation Drawer
    ActionBarDrawerToggle actionBarDrawerToggle; //Boton que desplegara el menu
    
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Le decimos al activity la vista principal, este es nuestro Navigation Drawer. 
        //Navigation Drawer muestra la vista de fragmentos y el menu desplegable Navigation View
        setContentView(R.layout.navigation_draw); 

        //Enlazamos el Navigation Drawer de la vista
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        //Incorporamos la barra superior de la aplicacion
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //Incorporamos el boton de menu a la barra superior izquierda.
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.app_name, R.string.app_name);
        //Indicamos al drawerLayout que escuche al boton para desplegar el menu
        drawerLayout.setDrawerListener(actionBarDrawerToggle);

        //Vista del menu del Navigation Drawer
        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation_view);
        //Enlazamos los elementos del menu con su respuesta
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            //Cuando un elemento del menu sea seleccionado
            public boolean onNavigationItemSelected(MenuItem item) {
                FragmentTransaction tx;
                //Para todas las opciones del menu 
                switch (item.getItemId()) {
                    //Transicion al fragmento HomeFragment
                    case R.id.menu_home:
                        tx = getSupportFragmentManager().beginTransaction();
                        //Cambiamos el fragmento
                        tx.replace(R.id.content_frame, new HomeFragment()); 
                        drawerLayout.closeDrawers(); //Cerramos el menu
                        break; 
                    ... //Resto de opciones del menu
                } 
            });
        } 
        ...
    }