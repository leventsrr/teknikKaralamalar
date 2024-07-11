# Çalışma konusu: Lifecycle farkındalığı olan sınıflar ile çalışma

## CounterComponentClass
- Bağlı olduğu activity onResume() metoduna girdiğinde sayaç başlatır ve devam ettirilir.
- Activity onPause mettodune girdiğinde ise durdurulur.

## FocusMusicComponent
- Eğer ekranın altındaki premium user checkboxı aktifleştirilirse uygulama  
  arka plana alınsa dahi müzik çalmaya devam eder ama aktif değilse activity  
  onPause metoduna girdiğinde müzik durdurulur.

### Yöntemler:
1-DefaultLifecycleObserver  
2-LifecycleEventObserver  
-LifeCycleObserver depreceated olduğu için kullanılmadı-

https://github.com/leventsrr/teknikKaralamalar/assets/63983517/f7b33dc1-edf0-4dcb-b4c4-14ffa99d1f5c


