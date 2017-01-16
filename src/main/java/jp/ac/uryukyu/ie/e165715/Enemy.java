package jp.ac.uryukyu.ie.e165715;


import java.util.Random;

/**
 * 敵クラス。
 *  String name; //敵の名前
 *  int hitPoint; //敵のHP
 *  int attack; //敵の攻撃力
 *  boolean dead; //敵の生死状態。true=死亡。
 * Created by tnal on 2016/11/13.
 */
public class Enemy extends LivingThing {

    /**
     * コンストラクタ。名前、最大HP、攻撃力を指定する。
     *
     * @param name      モンスター名
     * @param maximumHP モンスターのHP
     * @param attack    モンスターの攻撃力
     */
    public Enemy(String name, int maximumHP, int attack) {
        super(name, maximumHP, attack);
    }

    public void wounded(int damage) {
        int hitPoint = getHitPoint();
        String  name = getName();

        hitPoint -= damage;
        setHitPoint(hitPoint);
        if (hitPoint <= 0) {
            setDead(true);
            System.out.printf("モンスター%sは倒れた。\n", name);
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
                System.out.printf("%sの攻撃！痛恨の一撃！！%sに%dのダメージを与えた！！\n", getName(), livingThing.getName(), damage * 2);
                livingThing.wounded(damage * 2);
            }else{
                System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", getName(), livingThing.getName(), damage);
                livingThing.wounded(damage);
            }
        }
    }

}