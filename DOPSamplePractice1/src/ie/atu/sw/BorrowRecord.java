package ie.atu.sw;

import java.time.LocalDate;

public class BorrowRecord {
	public final String memberId;
	public final LocalDate borrowDate;
	public final LocalDate returnDate;
	
	public BorrowRecord(String memberId, LocalDate borrowDate, LocalDate returnDate) {
		this.memberId = memberId;
		this.borrowDate = borrowDate;
		this.returnDate = returnDate;
	}
	
}
