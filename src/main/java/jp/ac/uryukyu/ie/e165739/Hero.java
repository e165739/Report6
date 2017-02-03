package jp.ac.uryukyu.ie.e165739;

public class Hero extends LivingThing{
    public Hero (String name, int hitPoint, int attack){
        super(name, hitPoint, attack);
    }

    @Override
    public void wounded(int damage){
        setHitPoint(getHitPoint()-damage);
        if( getHitPoint() <= 0 ) {
            setDead(true);
            System.out.printf("勇者%sはその場に倒れてしまった。\n", getName());
        }
    }

    @Override
    public void attack(LivingThing opponent){
        if( isDead()==false ) {
            int damage = (int) (Math.random() * getAttack());
            int rand = (int)(Math.random() * 100);
            if(damage == 0) {
                System.out.printf("%sの攻撃！,,,だが、%sは攻撃を回避した！\n", getName(), opponent.getName());
            }else if(rand < 30){
                damage = damage*2;
                System.out.printf("%sの攻撃！会心の一撃！！%sに%dのダメージを与えた！！\n", getName(), opponent.getName(), damage);
            }else{
                System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", getName(), opponent.getName(), damage);
            }
            opponent.wounded(damage);
        }
    }
}