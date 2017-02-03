package jp.ac.uryukyu.ie.e165739;

public class LivingThing {
    private String name;
    private int hitPoint;
    private int attack;
    private boolean dead;

    public LivingThing (String name, int hitPoint, int attack) {
        this.name = name;
        this.hitPoint = hitPoint;
        this.attack = attack;
        dead = false;
        System.out.printf("%sのHPは%d。攻撃力は%dです。\n", name, hitPoint, attack);
    }

    public void setDead(boolean dead){
        this.dead = dead;
    }
    public boolean isDead(){
        return  dead;
    }

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }

    public void setHitPoint(int hitPoint){ this.hitPoint = hitPoint; }
    public int getHitPoint(){
        return hitPoint;
    }

    public void setAttack(int attack){ hitPoint = attack;}
    public int getAttack(){
        return attack;
    }

    public void attack(LivingThing opponent){
        if( !dead ) {
            int damage = (int) (Math.random() * attack);
            System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", name, opponent.getName(), damage);
            opponent.wounded(damage);
        }
    }

    public void wounded(int damage){
        setHitPoint(getHitPoint()-damage);
        if( hitPoint <= 0 ) {
            dead = true;
        }
    }
}