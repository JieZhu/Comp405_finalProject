/**
 * 
 */
package edu.rice.jz52.server.domain;

import java.util.List;

import javax.jdo.annotations.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

import edu.rice.jz52.server.EMF;

/**
 * @author jz52@rice.edu
 *
 */
@Entity
public class GameBoard {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Version
	@Column(name = "version")
	private Integer version = 0;
	
	private Integer rowNumber;
	
	private Integer columnNumber;
	
	private List<Integer> cells;

	/**
	 * this a getter method for field cells
	 * @return the cells
	 */
	public List<Integer> getCells() {
		return cells;
	}

	/**
	 * this is a setter method for field cells
	 * @param cells the cells to set
	 */
	public void setCells(List<Integer> cells) {
		this.cells = cells;
	}

	/**
	 * this a getter method for field id
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * this a getter method for field version
	 * @return the version
	 */
	public Integer getVersion() {
		return version;
	}

	/**
	 * this a getter method for field rowNumber
	 * @return the rowNumber
	 */
	public Integer getRowNumber() {
		return rowNumber;
	}

	/**
	 * this a getter method for field columnNumber
	 * @return the columnNumber
	 */
	public Integer getColumnNumber() {
		return columnNumber;
	}

	/**
	 * this is a setter method for field rowNumber
	 * @param rowNumber the rowNumber to set
	 */
	public void setRowNumber(Integer rowNumber) {
		this.rowNumber = rowNumber;
	}

	/**
	 * this is a setter method for field columnNumber
	 * @param columnNumber the columnNumber to set
	 */
	public void setColumnNumber(Integer columnNumber) {
		this.columnNumber = columnNumber;
	}

	/**
	 *  It is mandatory to have a find[EntityClass] here!!!
	 * @param id
	 * @return
	 */
	public static GameBoard findGameBoard(Long id){
		if (id == null) 
			return null;
		EntityManager em = entityManager();
		try {
			GameBoard gameBoard = em.find(GameBoard.class, id);
			return gameBoard;
		} finally {
			em.close();
		}
	}
	
	public void persist(){
		EntityManager em = entityManager();
		try {
			em.persist(this);
		} finally {
			em.close();
		}
	}

	public void remove(){
		EntityManager em = entityManager();
		try {
			GameBoard gameBoard = em.find(GameBoard.class, this.id);
			em.remove(gameBoard);
		} finally {
			em.close();
		}
	}
	
	/**
	 * @return
	 */
	private static final EntityManager entityManager() {
		return EMF.get().createEntityManager();
	}
	
}
