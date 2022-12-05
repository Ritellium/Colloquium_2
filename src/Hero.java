class Hero {
    private Integer x;
    private Integer y;
    private Integer health;
    private boolean dead;

    Hero(int _x, int _y, Integer _health)
    {
        x = _x;
        y = _y;
        health = _health;
        dead = false;
    }

    void get_damage(Integer damage)
    {
        if (damage >= health)
        {
            health = 0;
            dead = true;
        }
        else {
            health -= damage;
            dead = false;
        }
    }

    public Integer getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }

    public boolean isDead()
    {
        return dead;
    }

    public Integer getHealth() {
        return health;
    }
}
