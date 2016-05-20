/*Copyright 2016 Deepak Kumar
Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at
http://www.apache.org/licenses/LICENSE-2.0
Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
This code is written by Deepak Kumar */

package bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
@Entity(name="ata_tbl_payment_history")
public class PaymentHistoryBean
{
        @Id
        @Column(name="booking_id")
		private String bookingId;
        @Column(name="total_fare")
        private float totalFare;
        @Column(name="mode_of_payment")
        private String modeOfPayment;
        @Column(name="credit_card_number")
        private String creditCardNumber;
		public String getBookingId() {
			return bookingId;
		}
		public void setBookingId(String bookingId) {
			this.bookingId = bookingId;
		}
		public float getTotalFare() {
			return totalFare;
		}
		public void setTotalFare(float totalFare) {
			this.totalFare = totalFare;
		}
		public String getModeOfPayment() {
			return modeOfPayment;
		}
		public void setModeOfPayment(String modeOfPayment) {
			this.modeOfPayment = modeOfPayment;
		}
		public String getCreditCardNumber() {
			return creditCardNumber;
		}
		public void setCreditCardNumber(String creditCardNumber) {
			this.creditCardNumber = creditCardNumber;
		}

}
