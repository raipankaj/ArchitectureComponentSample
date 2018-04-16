package sample.example.archcomponentsample

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import sample.example.archcomponentsample.data.UserRepository
import sample.example.archcomponentsample.db.DatabaseUtils
import sample.example.archcomponentsample.db.User
import sample.example.archcomponentsample.viewmodels.UserViewModel
import sample.example.archcomponentsample.viewmodels.UserViewmodelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var mUserViewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userViewModelFactory = UserViewmodelFactory(UserRepository(DatabaseUtils.getUserDatabase(this)))
        mUserViewModel = ViewModelProviders.of(this, userViewModelFactory).get(UserViewModel::class.java)

        val userAdapter = UserSyncAdapter()
        mUserViewModel.getAllUsersList().observe(this, Observer { user ->
            userAdapter.submitList(user)
            recyclerUser.smoothScrollToPosition(user?.size ?: 0)
        })

        recyclerUser.adapter = userAdapter

        btAdd.setOnClickListener {
            val user = User()
            user.name = etName.text.toString()
            mUserViewModel.insertUser(user)
        }
    }
}
