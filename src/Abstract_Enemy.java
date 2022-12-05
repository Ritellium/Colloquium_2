abstract class Abstract_Enemy {
    protected Hero hero_ref;
    protected Integer x;
    protected Integer y;

    Abstract_Enemy(int _x, int _y, Hero ref)
    {
        x = _x;
        y = _y;
        hero_ref = ref;
    }

    void AI_action()
    {
        attack();
        move();
    }
    abstract void move();
    abstract void attack();
}

class Enemy_trooper extends Abstract_Enemy {

    protected Integer attack_range;
    protected Integer damage;

    Enemy_trooper(int _x, int _y, Hero ref)
    {
        super( _x, _y, ref);
        attack_range = 15;
        damage = 25;
    }
    @Override
    void move()
    {
        double distToHero = Math.sqrt((x- hero_ref.getX())*(x- hero_ref.getX()) + (y- hero_ref.getY())*(y- hero_ref.getY()));
        double move_x = ((double)(hero_ref.getX() - x) / distToHero) * 10;
        double move_y = ((double)(hero_ref.getY() - y) / distToHero) * 10;

        x += (int)move_x;
        y += (int)move_y;
    }
    @Override
    void attack()
    {
        double distToHero = Math.sqrt((x- hero_ref.getX())*(x- hero_ref.getX()) + (y- hero_ref.getY())*(y- hero_ref.getY()));
        if ((distToHero) <= attack_range)
        {
            hero_ref.get_damage(damage);
        }
    }
}

class Enemy_cannon extends Abstract_Enemy {

    protected Integer attack_range_nearest;
    protected Integer attack_range_farthest;

    protected Integer damage_distant;

    Enemy_cannon(int _x, int _y, Hero ref)
    {
        super( _x, _y, ref);
        attack_range_nearest = 20;
        attack_range_farthest = 40;
        damage_distant = 40;
    }
    @Override
    void move() {}
    @Override
    void attack()
    {
        double distToHero = Math.sqrt((x- hero_ref.getX())*(x- hero_ref.getX()) + (y- hero_ref.getY())*(y- hero_ref.getY()));
        if ((distToHero) >= attack_range_nearest && (distToHero) <= attack_range_farthest)
        {
            hero_ref.get_damage(damage_distant);
        }
    }
}

class Enemy_archer extends Abstract_Enemy{
    protected Integer attack_range_nearest;
    protected Integer attack_range_farthest;

    protected Integer damage_melee;

    protected Integer damage_distant;

    Enemy_archer(int _x, int _y, Hero ref)
    {
        super( _x, _y, ref);
        attack_range_nearest = 10;
        attack_range_farthest = 35;
        damage_melee = 10;
        damage_distant = 15;
    }
    @Override
    void move()
    {
        double distToHero = Math.sqrt((x- hero_ref.getX())*(x- hero_ref.getX()) + (y- hero_ref.getY())*(y- hero_ref.getY()));
        double move_x = ((double)(hero_ref.getX() - x) / distToHero) * 5;
        double move_y = ((double)(hero_ref.getY() - y) / distToHero) * 5;

        x += (int)move_x;
        y += (int)move_y;
    }
    @Override
    void attack()
    {
        double distToHero = Math.sqrt((x- hero_ref.getX())*(x- hero_ref.getX()) + (y- hero_ref.getY())*(y- hero_ref.getY()));
        if ((distToHero) <= attack_range_nearest)
        {
            hero_ref.get_damage(damage_melee);
        }
        else if ((distToHero) >= attack_range_nearest)
        {
            hero_ref.get_damage(damage_distant);
        }
    }
}

class Enemy_mage extends Abstract_Enemy{

    protected Integer damage_distant;

    protected Integer kill_number;

    Enemy_mage(int _x, int _y, Hero ref)
    {
        super( _x, _y, ref);
        damage_distant = 15;
        kill_number = 5;
    }
    @Override
    void move()
    {
        x = (int)(Math.random()* 100) % 100 - 50;
        y = (int)(Math.random()* 100) % 100 - 50;
    }
    @Override
    void attack()
    {
        if ((hero_ref.getX() % 10 + hero_ref.getY() % 10 <= kill_number - 1) && (hero_ref.getX() % 10 + hero_ref.getY() % 10 <= kill_number + 1))
        {
            hero_ref.get_damage(damage_distant);
            kill_number = (int)(Math.random()* 7) % 7 + 1;
        }
    }
}