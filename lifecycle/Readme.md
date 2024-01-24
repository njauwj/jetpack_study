### 如何使用LifeCycle解耦页面与组件
1. 自定义一个组件，实现接口DefaultLifecycleObserver/LifecycleEventObserver，重写方法的逻辑
```kotlin
class MyChronometer(context: Context?, attrs: AttributeSet?) : Chronometer(context, attrs),
    DefaultLifecycleObserver {
    override fun onPause(owner: LifecycleOwner) {
        super.onPause(owner)
    }
    override fun onResume(owner: LifecycleOwner) {
        super.onResume(owner)
    }
}
```
2. 将该组件放入监听器
```kotlin
class MyChronometerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_chronometer)
        var myChronometer = findViewById<MyChronometer>(R.id.chronometer)
        lifecycle.addObserver(myChronometer)
    }
}
```