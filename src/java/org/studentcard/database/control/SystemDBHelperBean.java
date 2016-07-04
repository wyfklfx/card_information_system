package org.studentcard.database.control;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Zhou Shengyun <GGGZ-1101-28@Live.cn>
 */
@Stateless
public class SystemDBHelperBean extends EntityManagerHelper{
    @PersistenceContext(unitName = "StudentCardSystemPU")
    private EntityManager entityManager;

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }
    
}
