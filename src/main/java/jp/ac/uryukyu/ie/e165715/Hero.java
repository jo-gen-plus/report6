package jp.ac.uryukyu.ie.e165715;
import java.util.Random;


/**
 * ヒーロークラス。
 *  String name; //ヒーローの名前
 *  int hitPoint; //ヒーローのHP
 *  int attack; //ヒーローの攻撃力
 *  boolean dead; //ヒーローの生死状態。true=死亡。
 * Created by tnal on 2016/11/13.
 */
public class Hero extends LivingThing{

    /**
     * コンストラクタ。名前、最大HP、攻撃力を指定する。
     * @param name ヒーロー名
     * @param maximumHP ヒーローのHP
     * @param attack ヒーローの攻撃力
     */
    public Hero (String name, int maximumHP, int attack) {
        super(name,maximumHP,attack);
    }
    public void wounded(int damage) {
        int hitPoint = getHitPoint();
        String  name = getName();

        hitPoint -= damage;
        setHitPoint(hitPoint);
        if (hitPoint <= 0) {
             setDead(true);
            System.out.printf("%sは道半ばで力尽きてしまった。\n", name);
        }
    }
    public void attack( LivingThing livingThing){
        int damage = (int)(Math.random() * getAttack());
        Random rnd = new Random();
        int ran = rnd.nextInt(9);
        if (isDead() != true) {
            if (damage == 0){
                System.out.printf("%sの攻撃！,,,だが、%sは攻撃を回避した！\n", getName(), livingThing.getName(), damage);
            }else if (0 <= ran && ran <= 2){
                System.out.printf("%sの攻撃！会心の一撃！！%sに%dのダメージを与えた！！\n", getName(), livingThing.getName(), damage * 2);
                livingThing.wounded(damage * 2);
            }else{
                System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", getName(), livingThing.getName(), damage);
                livingThing.wounded(damage);
            }
        }
    }







}