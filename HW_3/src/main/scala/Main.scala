/*Для каждого дня проката известны следующие признаки:
 season: 1 - весна, 2 - лето, 3 - осень, 4 - зима
yr: 0 - 2011, 1 - 2012
mnth: от 1 до 12
holiday: 0 - нет праздника, 1 - есть праздник
weekday: от 0 до 6
workingday: 0 - нерабочий день, 1 - рабочий день
weathersit: оценка благоприятности погоды от 1 (чистый, ясный день) до 4 (ливень, туман)
temp: температура в Цельсиях
atemp: температура по ощущениям в Цельсиях
hum: влажность
windspeed(mph): скорость ветра в милях в час
windspeed(ms): скорость ветра в метрах в секунду
cnt: количество арендованных велосипедов (это целевой признак, его мы будем предсказывать)*/

import breeze.linalg._
import breeze.numerics.abs
import java.io._

object Main extends App{

  def MSE(y: DenseVector[Double], pred: DenseVector[Double]): Double = {
    sum(abs(pred - y)) / y.size
  }

  var data_tr_val = csvread(new File("C:\\Users\\Анастасия\\IdeaProjects\\BD_scala\\src\\main\\scala\\data\\bikes_rent_train.csv"), ',', skipLines = 1)

  var ind_tr = (data_tr_val.rows * 0.8).toInt
  var data_train = data_tr_val(0 until ind_tr, ::)
  var data_val = data_tr_val(ind_tr until data_tr_val.rows, ::)

  var X_tr = data_train(::, 0 until data_train.cols - 1)
  var y_tr = data_train(::, data_train.cols - 1)

  var X_val = data_val(::, 0 until data_val.cols - 1)
  var y_val = data_val(::, data_val.cols - 1)

  var W = inv(X_tr.t * X_tr) * X_tr.t * y_tr
  var y_pr_val = X_val * W
  println(s"MAE on validation data = ${MSE(y_val, y_pr_val)}")
  csvwrite(new File("C:\\Users\\Анастасия\\IdeaProjects\\BD_scala\\src\\main\\scala\\data\\bikes_rent_result_val.csv"), y_pr_val.toDenseMatrix, separator = '\n')

  val data_test = csvread(new File("C:\\Users\\Анастасия\\IdeaProjects\\BD_scala\\src\\main\\scala\\data\\bikes_rent_test.csv"), ',', skipLines = 1)

  var X_test = data_test(::, 0 to data_test.cols - 2)
  var y_test = data_test(::, data_test.cols - 1)
  var y_pr_test = X_test * W
  println(s"MAE on test data = ${MSE(y_test, y_pr_test)}")
  csvwrite(new File("C:\\Users\\Анастасия\\IdeaProjects\\BD_scala\\src\\main\\scala\\data\\bikes_rent_result_test.csv"), y_pr_test.toDenseMatrix, separator = '\n')
}