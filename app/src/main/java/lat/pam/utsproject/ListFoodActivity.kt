package lat.pam.utsproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ListFoodActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: FoodAdapter
    private lateinit var foodList: List<Food>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_list_food)


        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val tvName = findViewById<TextView>(R.id.tvName)
        val userName = intent.getStringExtra("USERNAME")
        tvName.text = "Selamat datang " + userName

        val fab: FloatingActionButton = findViewById(R.id.fabAddOrder)

        fab.setOnClickListener {
            // Aksi ketika FAB ditekan
            // Misalnya, arahkan ke Activity lain untuk menambahkan pesanan
            val intent = Intent(this, OrderActivity::class.java)
            startActivity(intent)
        }



        // Menyiapkan data makanan
        foodList = listOf(
            Food("Batagor", "Baso tahu goreng", R.drawable.batagor),
            Food("Black Salad", "Salad segar yang hitam", R.drawable.black_salad),
            Food("Cappucino", "kopi cappucino gabisa jelasinnya", R.drawable.cappuchino),
            Food("cheesecake","ini enak merk cheesezz", R.drawable.cheesecake),
            Food("Cireng","Cireng isi depan min enak",R.drawable.cireng),
            Food("Donut","Donut jco boikot ga?",R.drawable.donut)
        )

        adapter = FoodAdapter(foodList)
        recyclerView.adapter = adapter


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}