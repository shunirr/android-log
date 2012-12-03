# Android Log

Android の Log クラス (android.util.Log) が不便なので、便利になるようにしていく (予定地)

## Usage

### 普通のログ

* TAG が省略できる (定数にしてるだけ)

```
Log.d("this is test log");
```

### トレースログ

* これまで
 * メソッドの頭とかで

```
Log.d(TAG, "<HogeActivity/onCreate>");
```

* 便利なログだと

```
Log.trace();
```

