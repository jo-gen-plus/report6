package e165715;

/**
 * 生物クラス。
 *
 * Created by e165715 on 2016/11/24.
 */
public class LivingThing {
    private String name;
    private int hitPoint;
    private int attack;
    private boolean dead;
    /**
     * コンストラクタ。名前、最大HP、攻撃力を指定する。
     * @param name 生物名
     * @param maximumHP 生物のHP
     * @param attack 生物の攻撃力
     */
    public LivingThing (String name, int maximumHP, int attack) {
        this.name = name;
        hitPoint = maximumHP;
        this.attack = attack;
        dead = false;
        System.out.printf("%sのHPは%d。攻撃力は%dです。\n", name, maximumHP, attack);
    }


    /**
     * 相手へ攻撃するメソッド。
     * attackに応じて乱数でダメージを算出し、hero.wounded(),またはenemy.wounded()によりダメージ処理を実行。
     * @param livingThing 攻撃対象
     */
    public void attack( LivingThing livingThing){
        int damage = (int)(Math.random() * attack);
        if (dead != true) {
            System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", name, livingThing.getName(), damage);
            livingThing.wounded(damage);
        }
    }

    /**
     * 自身へ攻撃されたときのダメージ処理をするメソッド。
     * 指定されたダメージを hitPoint から引き、死亡判定を行う。
     * @param damage 受けたダメージ
     */
    public void wounded(int damage){
        hitPoint -= damage;
        if( hitPoint < 0 ) {
            dead = true;
        }
    }
    /**
     * getterメソッドと同等。生死をboolean表現しているためメソッド名をisDead()とした。
     * @return boolean
     */
    public boolean isDead() {
        return dead;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public  int getHitPoint(){
        return hitPoint;
    }

    public void setHitPoint(int hitPoint){
        this.hitPoint = hitPoint;
    }

    public  int getAttack(){
        return attack;
    }

    public  void setAttack(int attack){
        this.attack = attack;
    }

}
