import { Component } from '@angular/core';
import { LabseqService } from '../labseq.service';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-labseq',
  templateUrl: './labseq.component.html',
  styleUrls: ['./labseq.component.css'],
  standalone: true,
  imports: [CommonModule, FormsModule]
})
export class LabseqComponent {
  sequenceValue: string | null = null;
  inputNumber: number | null = null;
  errorMessage: string | null = null;

  constructor(private labseqService: LabseqService) {}

  async getSequenceValue(): Promise<void> {
    this.errorMessage = null; // Reset error message

    // Validate input and handle negative numbers
    if (this.inputNumber === null) {
      this.errorMessage = 'Please enter a number.';
      this.sequenceValue = null; // Clear previous value
      return;
    }

    if (this.inputNumber < 0) {
      this.errorMessage = 'Negative numbers are not allowed. Please enter a non-negative integer.';
      this.sequenceValue = null; // Clear previous value
      return;
    }

    try {
      this.sequenceValue = await this.labseqService.getLabseqValue(this.inputNumber);
    } catch (error) {
      console.error('Error fetching sequence value:', error);
      this.errorMessage = 'Failed to fetch sequence value. Please try again later.';
      this.sequenceValue = null; // Clear previous value
    }
  }
}
