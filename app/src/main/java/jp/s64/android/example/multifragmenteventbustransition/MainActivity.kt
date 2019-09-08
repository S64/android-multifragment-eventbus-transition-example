package jp.s64.android.example.multifragmenteventbustransition

import android.os.Bundle
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe

class MainActivity : AppCompatActivity() {

    override fun onStart() {
        super.onStart()
        EventBus.getDefault().register(this)
    }

    override fun onStop() {
        super.onStop()
        EventBus.getDefault().unregister(this)
    }

    private val container: ViewGroup by lazy { findViewById<ViewGroup>(R.id.container) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        EventBus.getDefault().postSticky(FragmentTransitionEvent(
            FirstFragment::class,
            isFirst = true
        ))
    }

    @Subscribe(sticky = true)
    fun FragmentTransitionEvent<*>.onEvent() {
        val instance = fragmentClass.java.newInstance()
        supportFragmentManager.beginTransaction().apply {
            replace(container.id, instance)
            if (!isFirst) {
                addToBackStack(
                    "${fragmentClass.simpleName}_${supportFragmentManager.backStackEntryCount + 1}"
                )
            }
        }.commit()
    }

}
