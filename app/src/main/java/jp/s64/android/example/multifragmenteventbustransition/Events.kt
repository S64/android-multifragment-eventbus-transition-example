package jp.s64.android.example.multifragmenteventbustransition

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import kotlin.reflect.KClass

data class FragmentTransitionEvent<T : Fragment>(
    val fragmentClass: KClass<T>,
    val isFirst: Boolean
)
