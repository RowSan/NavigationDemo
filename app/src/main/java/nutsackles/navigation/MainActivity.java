package nutsackles.navigation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;


import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;

public class MainActivity extends AppCompatActivity {
Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar=(Toolbar) findViewById(R.id.toolbarMain);
        toolbar.setTitle("NavigationDemo");
        // Create the AccountHeader
        AccountHeader headerResult = new AccountHeaderBuilder()
                .withActivity(this)
                .withHeaderBackground(R.drawable.header)
                .addProfiles(
                        new ProfileDrawerItem().withName("Beeplove").withEmail("galacticobeeplove @gmail.com").withIcon(getResources().getDrawable(R.drawable.bird))
                )
                .withOnAccountHeaderListener(new AccountHeader.OnAccountHeaderListener() {
                    @Override
                    public boolean onProfileChanged(View view, IProfile profile, boolean currentProfile) {
                        return false;
                    }
                })
                .build();

        //if you want to update the items at a later time it is recommended to keep it in a variable
        PrimaryDrawerItem item1 = new PrimaryDrawerItem().withIdentifier(1).withName("Home").withIcon(getResources().getDrawable(R.drawable.bird));
        PrimaryDrawerItem item3 = new PrimaryDrawerItem().withIdentifier(3).withName("Contacts").withIcon(getResources().getDrawable(R.drawable.bird));
        SecondaryDrawerItem item2 = new SecondaryDrawerItem().withIdentifier(2).withName("Setting").withIcon(getResources().getDrawable(R.drawable.bird));

//create the drawer and remember the `Drawer` result object
        Drawer result = new DrawerBuilder()
                .withActivity(this)
                .withAccountHeader(headerResult)
                .withToolbar(toolbar)
                .addDrawerItems(
                        item1,
                        new DividerDrawerItem(),
                        item2,
                        new SecondaryDrawerItem().withName("Account").withIcon(getResources().getDrawable(R.drawable.bird)),
                        new DividerDrawerItem(),
                        item3,
                        new SecondaryDrawerItem().withName("Support us").withIcon(getResources().getDrawable(R.drawable.bird))


                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        // do something with the clicked item :D
                        switch(position){
                            case 1:
                                Intent intent= new Intent(MainActivity.this,Main2Activity.class);
                                startActivity(intent);
                                break;
                            case 2:
                                Intent intents= new Intent(MainActivity.this,Main2Activity.class);
                                startActivity(intents);
                                break;
                        }
                        return true;
                    }
                })
                .build();
    }
}
